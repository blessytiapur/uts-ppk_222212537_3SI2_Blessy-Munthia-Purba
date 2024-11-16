package com.polstatstis.volunteerpdt.service;

/*
 * @author blessy
 */

import com.polstatstis.volunteerpdt.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto user);
    UserDto getUserByNim(String nim);

    void updateUser(String nim, UserDto userDto);
    void deleteUser(String nim);
}
