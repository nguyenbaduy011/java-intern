package com.example.demo;

import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.repository.AuthorRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final AuthorRepository authorRepository;

    public DataInitializer(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    // Khởi tạo dữ liệu mẫu khi ứng dụng khởi động
    @PostConstruct
    public void init() {
        Author author1 = new Author("Author 1");
        author1.getBooks().add(new Book("Book 1", author1));
        author1.getBooks().add(new Book("Book 2", author1));

        Author author2 = new Author("Author 2");
        author2.getBooks().add(new Book("Book 3", author2));

        authorRepository.save(author1);
        authorRepository.save(author2);
    }
}