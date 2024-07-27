package org.example.tiny_news_api.service;

import org.example.tiny_news_api.dto.NewsDto;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class NewsService {

    private final ConcurrentHashMap<Long, NewsDto> data = new ConcurrentHashMap<>();

    public Collection<NewsDto> findAll() {
        return data.values();
    }

    public NewsDto findById(long id) {
        return data.get(id);
    }

    public NewsDto create(NewsDto newsDto) {
        long lastId = data.size() + 1;
        newsDto.setId(lastId);
        newsDto.setDate(Instant.now());
        data.put(lastId, newsDto);

        return data.get(newsDto.getId());
    }

    public NewsDto update(Long id, NewsDto newsDto) {
        newsDto.setId(id);
        newsDto.setDate(Instant.now());
        data.put(id, newsDto);

        return data.get(id);
    }

    public void delete(Long id) {
        data.remove(id);
    }
}
