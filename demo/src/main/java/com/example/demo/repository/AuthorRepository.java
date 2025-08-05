package com.example.demo.repository;

import com.example.demo.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    // Truy vấn gây ra N+1 query vì không sử dụng JOIN
    List<Author> findAll();

    // Truy vấn sử dụng LEFT JOIN FETCH để tránh N+1 query
    @Query("SELECT a FROM Author a LEFT JOIN FETCH a.books")
    List<Author> findAllWithBooks();
}