package io.desafio.VirtualLibabry.controller;

import io.desafio.VirtualLibabry.domainDTO.BookDTO;
import io.desafio.VirtualLibabry.repository.BookRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(path = "/books", consumes = "application/json", produces = "application/json")
public class BooksController {
    BookRepository bookRepo;

    @Autowired
    public BooksController (BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    @PostMapping
    public ResponseEntity<?> processPostBook(@Valid @RequestBody BookDTO book){
        BookDTO savedBook = bookRepo.save(book);

        URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/{title}")
                .buildAndExpand(savedBook.getTitle())
                .toUri();

        return ResponseEntity.created(location).body(book);
    }
}
