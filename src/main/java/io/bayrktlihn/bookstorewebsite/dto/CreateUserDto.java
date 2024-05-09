package io.bayrktlihn.bookstorewebsite.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateUserDto {
    private String fullName;
    private String password;
    private String email;


    public static CreateUserDto create(String fullname, String password, String email) {
        CreateUserDto createUserDto = new CreateUserDto();
        createUserDto.setEmail(email);
        createUserDto.setPassword(password);
        createUserDto.setFullName(fullname);
        return createUserDto;
    }
}
