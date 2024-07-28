package org.example.tiny_news_api.mapper;

import org.example.tiny_news_api.entity.Category;
import org.example.tiny_news_api.web.dto.category.CategoryListResponse;
import org.example.tiny_news_api.web.dto.category.CategoryResponse;
import org.example.tiny_news_api.web.dto.category.CategoryResponseWithoutNews;
import org.example.tiny_news_api.web.dto.category.UpsertCategoryRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

    Category requsetToCategory(UpsertCategoryRequest request);

    CategoryResponse categoryToResponse(Category category);

    CategoryResponseWithoutNews categoryResponseWithoutNews(Category category);

    default CategoryListResponse categoryListToCategoryListResponse(List<Category> categories) {
        CategoryListResponse response = new CategoryListResponse();

        response.setCategories(categories.stream().map(this::categoryToResponse).toList());

        return response;
    }

}
