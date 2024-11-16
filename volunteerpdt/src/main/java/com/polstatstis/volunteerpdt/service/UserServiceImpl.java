package com.polstatstis.volunteerpdt.service;

/*
 * @author blessy
 */

import com.polstatstis.volunteerpdt.dto.UserDto;
import com.polstatstis.volunteerpdt.entity.User;
import com.polstatstis.volunteerpdt.mapper.UserMapper;
import com.polstatstis.volunteerpdt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public UserDto createUser(UserDto userDto) {
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User user = userRepository.save(UserMapper.mapToUser(userDto));
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public UserDto getUserByNim(String nim) {
        User user = userRepository.findByNim(nim);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with NIM: " + nim);
        }
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public void updateUser(String nim, UserDto userDto) {
        // Mencari user berdasarkan NIM
        User existingUser = userRepository.findByNim(nim);
        if (existingUser == null) {
            throw new UsernameNotFoundException("User not found with NIM: " + nim);
        }
        // Memperbarui data user
        existingUser.setNama(userDto.getNama());
        existingUser.setEmail(userDto.getEmail());
        existingUser.setRole(userDto.getRole()); // Memperbarui role
        existingUser.setStatus(userDto.getStatus()); // Memperbarui status
        existingUser.setKelas(userDto.getKelas()); // Memperbarui kelas
        existingUser.setAngkatan(userDto.getAngkatan()); // Memperbarui angkatan
        existingUser.setUsia(userDto.getUsia()); // Memperbarui usia
        // Jika password diubah, mengenkripsi ulang password
        if (userDto.getPassword() != null && !userDto.getPassword().isEmpty()) {
            existingUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
        }
        // Menyimpan perubahan ke database
        userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(String nim) {
        User user = userRepository.findByNim(nim);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with NIM: " + nim);
        }
        // Hapus user dari database
        userRepository.delete(user);
    }
}
