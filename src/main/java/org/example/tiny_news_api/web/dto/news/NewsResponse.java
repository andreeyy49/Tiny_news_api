package org.example.tiny_news_api.web.dto.news;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.tiny_news_api.web.dto.category.CategoryResponseWithoutNews;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsResponse {

    private Long id;

    private String title;

    private String text;

    private Instant date;

    private CategoryResponseWithoutNews category;
}
