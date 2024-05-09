package io.bayrktlihn.bookstorewebsite.service;

import io.bayrktlihn.bookstorewebsite.dto.CreateUserDto;
import io.bayrktlihn.bookstorewebsite.dto.CreatedUserDto;
import io.bayrktlihn.bookstorewebsite.dto.UpdateUserDto;
import io.bayrktlihn.bookstorewebsite.dto.UpdatedUserDto;
import io.bayrktlihn.bookstorewebsite.dto.UserDto;
import io.bayrktlihn.bookstorewebsite.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    CreatedUserDto create(CreateUserDto createUser);

    UserDto findById(long id);

    UpdatedUserDto update(UpdateUserDto updateUserDto);

    void deleteById(long id);

    boolean checkPassword(String email, String password);
}
