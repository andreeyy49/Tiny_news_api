package org.example.tiny_news_api.web.controller;

import jakarta.persistence.EntityNotFoundException;
import org.example.tiny_news_api.web.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionController {
//
//    @ExceptionHandler(EntityNotFoundException.class)
//    public ResponseEntity<Map<String, Object>> notFound (EntityNotFoundException e) {
//        Map<String, Object> body = new HashMap<>();
//        body.put("message", e.getMessage());
//
//        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
//    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionDto notFound(EntityNotFoundException e) {
        return new ExceptionDto(e.getMessage());
    }
}
