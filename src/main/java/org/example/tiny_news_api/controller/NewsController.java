package org.example.tiny_news_api.controller;

import lombok.RequiredArgsConstructor;
import org.example.tiny_news_api.dto.NewsDto;
import org.example.tiny_news_api.service.NewsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/news")
public class NewsController {

    private final NewsService newsService;

    @GetMapping
    public Collection<NewsDto> findAll() {
        return newsService.findAll();
    }

    @GetMapping("/{id}")
    public NewsDto findById(@PathVariable Long id) {
        NewsDto newsDto = newsService.findById(id);
        if(newsDto == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Новость с id " + id + " не найдена");
        }

        return newsDto;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NewsDto create(@RequestBody NewsDto newsDto) {
        return newsService.create(newsDto);
    }

    @PutMapping("/{id}")
    public NewsDto update(@PathVariable Long id, @RequestBody NewsDto newsDto) {
        NewsDto oldNews = newsService.findById(id);
        if(oldNews == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Новость с id " + id + " не найдена");
        }

        return newsService.update(id, newsDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        NewsDto newsDto = newsService.findById(id);
        if(newsDto == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Новость с id " + id + " не найдена");
        }

        newsService.delete(id);
    }
}
