package org.example.tiny_news_api.repository;

import org.example.tiny_news_api.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
