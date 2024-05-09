package io.bayrktlihn.bookstorewebsite.mapper;

import io.bayrktlihn.bookstorewebsite.dto.CategoryDto;
import io.bayrktlihn.bookstorewebsite.dto.CreateCategoryDto;
import io.bayrktlihn.bookstorewebsite.dto.CreatedCategoryDto;
import io.bayrktlihn.bookstorewebsite.dto.UpdatedCategoryDto;
import io.bayrktlihn.bookstorewebsite.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDto categoryToCategoryDto(Category category);

    List<CategoryDto> categoryListToCategoryDtoList(List<Category> categories);

    UpdatedCategoryDto categoryToUpdatedCategoryDto(Category category);

    Category createCategoryDtoToCategory(CreateCategoryDto createCategory);

    CreatedCategoryDto categoryToCreatedCategoryDto(Category category);

}
