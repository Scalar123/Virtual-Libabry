package io.desafio.VirtualLibabry.controller;

import io.desafio.VirtualLibabry.domainDTO.BookDTO;
import io.desafio.VirtualLibabry.repository.BookRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.awt.print.Book;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(path = "/books", produces = "application/json")
public class BooksController {
    BookRepository bookRepo;

    @Autowired
    public BooksController (BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    @PostMapping
    public ResponseEntity<?> processPostBook(@Valid @RequestBody BookDTO book){
        BookDTO savedBook = bookRepo.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    @GetMapping("/{idTitle}")
    public ResponseEntity processGetBook(@PathVariable("idTitle") String id){
        Optional<BookDTO> book = bookRepo.findByIdTitle(id);
        if (book.isPresent())
            return ResponseEntity.ok(book.get());
        else
            return ResponseEntity.notFound().build();
    }

}
