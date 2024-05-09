package io.bayrktlihn.bookstorewebsite.service;

import io.bayrktlihn.bookstorewebsite.dto.CategoryDto;
import io.bayrktlihn.bookstorewebsite.dto.CreateCategoryDto;
import io.bayrktlihn.bookstorewebsite.dto.CreatedCategoryDto;
import io.bayrktlihn.bookstorewebsite.dto.UpdateCategoryDto;
import io.bayrktlihn.bookstorewebsite.dto.UpdatedCategoryDto;
import io.bayrktlihn.bookstorewebsite.entity.Category;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> findAll();

    CategoryDto findById(long id);

    UpdatedCategoryDto update(UpdateCategoryDto updateUserDto);

    void deleteById(long id);

    CreatedCategoryDto create(CreateCategoryDto createCategory);

    CategoryDto findByName(String name);

}
