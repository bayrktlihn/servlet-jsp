package io.bayrktlihn.bookstorewebsite.mapper;


import io.bayrktlihn.bookstorewebsite.dto.CreateCategoryDto;
import io.bayrktlihn.bookstorewebsite.dto.CreateUserDto;
import io.bayrktlihn.bookstorewebsite.dto.CreatedUserDto;
import io.bayrktlihn.bookstorewebsite.dto.UpdateUserDto;
import io.bayrktlihn.bookstorewebsite.dto.UpdatedUserDto;
import io.bayrktlihn.bookstorewebsite.dto.UserDto;
import io.bayrktlihn.bookstorewebsite.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User createUserDtoToUser(CreateUserDto createUser);

    CreatedUserDto userToCreatedUserDto(User user);

    UserDto userToUserDto(User user);

    User updateUserDtoToUser(UpdateUserDto updateUserDto);

    UpdatedUserDto userToUpdatedUserDto(User user);


}
