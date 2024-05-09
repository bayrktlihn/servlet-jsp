package io.bayrktlihn.bookstorewebsite.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateUserDto {
    private Long id;
    private String fullName;
    private String password;
    private String email;

    public static UpdateUserDto create(Long id, String fullName, String password, String email) {
        UpdateUserDto updateUserDto = new UpdateUserDto();
        updateUserDto.setId(id);
        updateUserDto.setFullName(fullName);
        updateUserDto.setPassword(password);
        updateUserDto.setEmail(email);
        return updateUserDto;
    }


}
