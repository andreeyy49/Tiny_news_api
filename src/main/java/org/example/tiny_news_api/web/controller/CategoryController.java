package org.example.tiny_news_api.web.controller;

import lombok.RequiredArgsConstructor;
import org.example.tiny_news_api.mapper.CategoryMapper;
import org.example.tiny_news_api.service.CategoryService;
import org.example.tiny_news_api.web.dto.category.CategoryListResponse;
import org.example.tiny_news_api.web.dto.category.CategoryResponse;
import org.example.tiny_news_api.web.dto.category.UpsertCategoryRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public CategoryListResponse findAll() {
        return categoryMapper.categoryListToCategoryListResponse(categoryService.findAll());
    }

    @GetMapping("/{id}")
    public CategoryResponse findById(@PathVariable Long id) {
        return categoryMapper.categoryToResponse(categoryService.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponse create(@RequestBody UpsertCategoryRequest request) {
        return categoryMapper.categoryToResponse(categoryService.save(categoryMapper.requsetToCategory(request)));
    }

    @PutMapping("/{id}")
    public CategoryResponse update(@PathVariable Long id, @RequestBody UpsertCategoryRequest request) {
        return categoryMapper.categoryToResponse(categoryService.update(id, categoryMapper.requsetToCategory(request)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        categoryService.delete(id);
    }
}
