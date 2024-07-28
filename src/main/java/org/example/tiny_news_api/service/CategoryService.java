package org.example.tiny_news_api.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.tiny_news_api.entity.Category;
import org.example.tiny_news_api.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException(MessageFormat.format("Категория с id:{0} не найдена", id)));
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public Category update(Long id, Category category) {
        Category updatedCategory = findById(id);
        updatedCategory.setTitle(category.getTitle());
        updatedCategory.setNewsList(category.getNewsList());

        return categoryRepository.save(updatedCategory);
    }

    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
