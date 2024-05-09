package io.bayrktlihn.bookstorewebsite.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateCategoryDto {
    private String name;

    public static CreateCategoryDto create(String name){
        CreateCategoryDto createCategory = new CreateCategoryDto();
        createCategory.setName(name);
        return createCategory;
    }
}
