package io.bayrktlihn.bookstorewebsite.service.impl;

import io.bayrktlihn.bookstorewebsite.dto.CategoryDto;
import io.bayrktlihn.bookstorewebsite.dto.CreateCategoryDto;
import io.bayrktlihn.bookstorewebsite.dto.CreatedCategoryDto;
import io.bayrktlihn.bookstorewebsite.dto.UpdateCategoryDto;
import io.bayrktlihn.bookstorewebsite.dto.UpdatedCategoryDto;
import io.bayrktlihn.bookstorewebsite.entity.Category;
import io.bayrktlihn.bookstorewebsite.exception.CategoryNameAlreadyExistsException;
import io.bayrktlihn.bookstorewebsite.exception.I18nSupportedException;
import io.bayrktlihn.bookstorewebsite.mapper.CategoryMapper;
import io.bayrktlihn.bookstorewebsite.repository.CategoryRepository;
import io.bayrktlihn.bookstorewebsite.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }


    @Override
    public List<CategoryDto> findAll() {
        List<Category> categories = categoryRepository.findAll();
        return categoryMapper.categoryListToCategoryDtoList(categories);
    }

    @Override
    public CategoryDto findById(long id) {
        Category category = categoryRepository.findById(id);
        return categoryMapper.categoryToCategoryDto(category);
    }

    @Override
    public UpdatedCategoryDto update(UpdateCategoryDto updateCategory) {
        Category category = categoryRepository.findById(updateCategory.getId());

        boolean sameNameUpdate = category.getName().equals(updateCategory.getName());
        if (!sameNameUpdate && categoryRepository.existsByName(updateCategory.getName())) {
            Object[] args = new Object[]{updateCategory.getName()};
            throw new CategoryNameAlreadyExistsException(args);
        }


        category.setName(updateCategory.getName());
        category = categoryRepository.save(category);
        return categoryMapper.categoryToUpdatedCategoryDto(category);
    }

    @Override
    public void deleteById(long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public CreatedCategoryDto create(CreateCategoryDto createCategory) {

        boolean categoryExists = categoryRepository.existsByName(createCategory.getName());
        if(categoryExists){
            throw new CategoryNameAlreadyExistsException(new Object[]{createCategory.getName()});
        }

        Category category = categoryMapper.createCategoryDtoToCategory(createCategory);
        category = categoryRepository.save(category);
        return categoryMapper.categoryToCreatedCategoryDto(category);
    }

    @Override
    public CategoryDto findByName(String name) {
        Category category = categoryRepository.findByName(name);
        return categoryMapper.categoryToCategoryDto(category);
    }
}
