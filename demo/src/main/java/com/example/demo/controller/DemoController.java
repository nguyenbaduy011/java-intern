package com.example.demo.controller;

import com.example.demo.entity.Author;
import com.example.demo.repository.AuthorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {

    private final AuthorRepository authorRepository;

    public DemoController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    // Endpoint demo N+1 query
    @GetMapping("/nplusone")
    public List<Author> getAuthorsWithNPlusOne() {
        List<Author> authors = authorRepository.findAll();
        // Truy cập books để kích hoạt N+1 query
        authors.forEach(author -> author.getBooks().size());
        return authors;
    }

    // Endpoint demo giải pháp với JOIN FETCH
    @GetMapping("/join")
    public List<Author> getAuthorsWithJoin() {
        // Sử dụng LEFT JOIN FETCH để tải Author và Books trong một truy vấn
        return authorRepository.findAllWithBooks();
    }
}