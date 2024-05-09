package io.bayrktlihn.bookstorewebsite.service.impl;

import io.bayrktlihn.bookstorewebsite.dto.CreateUserDto;
import io.bayrktlihn.bookstorewebsite.dto.CreatedUserDto;
import io.bayrktlihn.bookstorewebsite.dto.UpdateUserDto;
import io.bayrktlihn.bookstorewebsite.dto.UpdatedUserDto;
import io.bayrktlihn.bookstorewebsite.dto.UserDto;
import io.bayrktlihn.bookstorewebsite.entity.User;
import io.bayrktlihn.bookstorewebsite.exception.I18nSupportedException;
import io.bayrktlihn.bookstorewebsite.exception.UserNotFoundException;
import io.bayrktlihn.bookstorewebsite.mapper.UserMapper;
import io.bayrktlihn.bookstorewebsite.repository.UserRepository;
import io.bayrktlihn.bookstorewebsite.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }


    @Override
    public CreatedUserDto create(CreateUserDto createUser) {
        User user = userMapper.createUserDtoToUser(createUser);

        if (userRepository.existsByEmail(createUser.getEmail())) {
            Object[] args = new Object[]{createUser.getEmail()};
            throw I18nSupportedException.create("user.email.already.exists", args);
        }

        user = userRepository.save(user);
        return userMapper.userToCreatedUserDto(user);
    }

    @Override
    public UserDto findById(long id) {
        User user = userRepository.findById(id);

        if(user == null){
            throw new UserNotFoundException(id);
        }

        UserDto userDto = userMapper.userToUserDto(user);
        return userDto;
    }

    @Override
    public UpdatedUserDto update(UpdateUserDto updateUserDto) {
        User user = userRepository.findById(updateUserDto.getId());

        boolean sameEmailUpdate = user.getEmail().equals(updateUserDto.getEmail());
        if (!sameEmailUpdate && userRepository.existsByEmail(updateUserDto.getEmail())) {
            Object[] args = new Object[]{updateUserDto.getEmail()};
            throw I18nSupportedException.create("user.email.already.exists", args);
        }

        user.setEmail(updateUserDto.getEmail());
        user.setPassword(updateUserDto.getPassword());
        user.setFullName(updateUserDto.getFullName());

        user = userRepository.save(user);
        UpdatedUserDto updatedUserDto = userMapper.userToUpdatedUserDto(user);
        return updatedUserDto;
    }

    @Override
    public void deleteById(long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
    }

    @Override
    public boolean checkPassword(String email, String password) {
        return userRepository.checkPassword(email, password);
    }

}
