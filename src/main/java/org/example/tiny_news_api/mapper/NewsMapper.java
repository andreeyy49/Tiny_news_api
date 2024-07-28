package org.example.tiny_news_api.mapper;

import org.example.tiny_news_api.entity.Category;
import org.example.tiny_news_api.entity.News;
import org.example.tiny_news_api.service.CategoryService;
import org.example.tiny_news_api.web.dto.news.NewsResponse;
import org.example.tiny_news_api.web.dto.news.NewsListResponse;
import org.example.tiny_news_api.web.dto.news.NewsResponseWithoutCategory;
import org.example.tiny_news_api.web.dto.news.UpsertNewsRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {CategoryMapper.class})
public abstract class NewsMapper {

    @Autowired
    private CategoryService categoryService;

    @Mapping(source = "categoryId", target = "category", qualifiedByName = "mapCategory")
    public abstract News requestToNews(UpsertNewsRequest request);

    public abstract NewsResponse newsToResponse(News news);

    public abstract NewsResponseWithoutCategory newsResponseWithoutCategory(News news);

    public NewsListResponse newsListToNewsListResponse(List<News> newsList) {
        NewsListResponse newsDtoList = new NewsListResponse();

        newsDtoList.setNews(newsList.stream()
                .map(this::newsToResponse)
                .toList());

        return newsDtoList;
    }

    @Named("mapCategory")
    Category mapCategory(Long categoryId) {
        return categoryService.findById(categoryId);
    }
}
