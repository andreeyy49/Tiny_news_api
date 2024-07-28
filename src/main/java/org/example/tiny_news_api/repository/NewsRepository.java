package org.example.tiny_news_api.repository;

import org.example.tiny_news_api.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {
}
