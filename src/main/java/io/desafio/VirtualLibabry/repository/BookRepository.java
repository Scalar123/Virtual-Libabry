package io.desafio.VirtualLibabry.repository;

import io.desafio.VirtualLibabry.domainDTO.BookDTO;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BookRepository extends CrudRepository<BookDTO,String> {
    Optional<BookDTO> findByIdTitle(String string);
    Iterable<BookDTO> findAllByAuthor(String str);
}
