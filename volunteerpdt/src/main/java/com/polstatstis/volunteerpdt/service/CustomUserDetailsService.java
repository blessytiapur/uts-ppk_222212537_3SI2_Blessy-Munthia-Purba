package com.polstatstis.volunteerpdt.service;

/*
 * @author blessy
 */
import com.polstatstis.volunteerpdt.repository.UserRepository;
import com.polstatstis.volunteerpdt.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;
    
    @Override
    public UserDetails loadUserByUsername(String nim) throws
    UsernameNotFoundException {
        User user = userRepository.findByNim(nim);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + nim);
        }
        UserDetails userDetails =
                org.springframework.security.core.userdetails.User.builder()
                        .username(user.getNim())
                        .password(user.getPassword())
                        .build();
        return userDetails;
    }
}
