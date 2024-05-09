package io.bayrktlihn.bookstorewebsite.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreatedUserDto {
    private Long id;
    private String fullName;
    private String email;
    private String password;
}
