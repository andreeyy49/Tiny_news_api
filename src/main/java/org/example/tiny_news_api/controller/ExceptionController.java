package org.example.tiny_news_api.controller;

import org.example.tiny_news_api.dto.ExceptionDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Map<String, Object>> notFound (ResponseStatusException e) {
        Map<String, Object> body = new HashMap<>();
        body.put("message", e.getReason());

        return new ResponseEntity<>(body, e.getStatusCode());
    }
}
