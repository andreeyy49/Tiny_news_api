package org.example.tiny_news_api.web.dto.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.tiny_news_api.web.dto.news.NewsResponseWithoutCategory;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponse {

    private Long id;

    private String title;

    private List<NewsResponseWithoutCategory> newsList = new ArrayList<>();
}
