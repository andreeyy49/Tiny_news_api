package org.example.tiny_news_api.web.controller;

import lombok.RequiredArgsConstructor;
import org.example.tiny_news_api.mapper.NewsMapper;
import org.example.tiny_news_api.web.dto.news.NewsResponse;
import org.example.tiny_news_api.service.NewsService;
import org.example.tiny_news_api.web.dto.news.NewsListResponse;
import org.example.tiny_news_api.web.dto.news.UpsertNewsRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/news")
public class NewsController {

    private final NewsService newsService;
    private final NewsMapper newsMapper;

    @GetMapping
    public NewsListResponse findAll() {
        return newsMapper.newsListToNewsListResponse(newsService.findAll());
    }

    @GetMapping("/{id}")
    public NewsResponse findById(@PathVariable Long id) {
        return newsMapper.newsToResponse(newsService.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NewsResponse create(@RequestBody UpsertNewsRequest request) {
        return newsMapper.newsToResponse(newsService.create(newsMapper.requestToNews(request)));
    }

    @PutMapping("/{id}")
    public NewsResponse update(@PathVariable Long id, @RequestBody UpsertNewsRequest request) {
        return newsMapper.newsToResponse(newsService.update(id, newsMapper.requestToNews(request)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        newsService.delete(id);
    }
}
