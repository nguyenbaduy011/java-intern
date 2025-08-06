package com.example.librarymanagement.service;

import com.example.librarymanagement.model.entity.Author;
import com.example.librarymanagement.repository.AuthorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LibraryService {
    private static final Logger log = LoggerFactory.getLogger(LibraryService.class);
    private final AuthorRepository authorRepository;

    public Boolean findByName(String name) {
        return authorRepository.existsByName(name);
    }

    @Transactional
    public void addAuthor(Author author) {
        try {
            if (authorRepository.existsByName(author.getName())) {
                log.debug("Author already exists");
                throw new RuntimeException("Author already exists");
            }
            authorRepository.save(author);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
