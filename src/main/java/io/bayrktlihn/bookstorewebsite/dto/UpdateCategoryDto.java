package io.bayrktlihn.bookstorewebsite.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateCategoryDto {
    private Long id;
    private String name;

    public static UpdateCategoryDto create(Long id, String name){
        UpdateCategoryDto updateCategoryDto = new UpdateCategoryDto();
        updateCategoryDto.setId(id);
        updateCategoryDto.setName(name);
        return updateCategoryDto;
    }
}
