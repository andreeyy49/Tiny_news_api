package org.example.tiny_news_api.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.tiny_news_api.entity.News;
import org.example.tiny_news_api.repository.NewsRepository;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsService {

    private final NewsRepository newsRepository;

    public List<News> findAll() {
        return newsRepository.findAll();
    }

    public News findById(long id) {
        return newsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Новость с id:{0} не найдена", id)));
    }

    public News create(News news) {
        news.setDate(Instant.now());

        return newsRepository.save(news);
    }

    public News update(Long id, News news) {
        News updatedNews = findById(id);
        updatedNews.setTitle(news.getTitle());
        updatedNews.setDate(news.getDate());
        updatedNews.setText(news.getText());
        updatedNews.setDate(Instant.now());

        return newsRepository.save(updatedNews);
    }

    public void delete(Long id) {
        newsRepository.deleteById(id);
    }
}
