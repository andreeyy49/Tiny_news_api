package org.example.tiny_news_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsDto {

    private Long id;

    private String title;

    private String text;

    private Instant date;
}
