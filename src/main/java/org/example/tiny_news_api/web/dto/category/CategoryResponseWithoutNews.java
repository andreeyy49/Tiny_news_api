package org.example.tiny_news_api.web.dto.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponseWithoutNews {

    private Long id;

    private String title;
}
