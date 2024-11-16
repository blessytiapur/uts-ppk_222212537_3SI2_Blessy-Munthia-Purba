package com.polstatstis.volunteerpdt.mapper;

/*
 * @author blessy
 */

import com.polstatstis.volunteerpdt.dto.UserDto;
import com.polstatstis.volunteerpdt.entity.User;

public class UserMapper {
   public static User mapToUser(UserDto userDto){
        return User.builder()
                .id(userDto.getId())
                .nim(userDto.getNim())
                .role(userDto.getRole())
                .nama(userDto.getNama())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .status(userDto.getStatus())
                .kelas(userDto.getKelas())
                .angkatan(userDto.getAngkatan())
                .usia(userDto.getUsia())
                .build();
    }
    public static UserDto mapToUserDto(User user){
        return UserDto.builder()
                .id(user.getId())
                .nim(user.getNim())
                .role(user.getRole())
                .nama(user.getNama())
                .email(user.getEmail())
                .password(user.getPassword())
                .status(user.getStatus())
                .kelas(user.getKelas())
                .angkatan(user.getAngkatan())
                .usia(user.getUsia())
                .build();
    }
}
