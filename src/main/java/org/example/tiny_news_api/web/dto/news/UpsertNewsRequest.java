package org.example.tiny_news_api.web.dto.news;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpsertNewsRequest {

    private String title;

    private String text;

    private Long categoryId;

}
