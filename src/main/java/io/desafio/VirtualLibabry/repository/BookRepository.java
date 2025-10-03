package io.desafio.VirtualLibabry.repository;

import io.desafio.VirtualLibabry.domainDTO.BookDTO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<BookDTO,String> {

}
