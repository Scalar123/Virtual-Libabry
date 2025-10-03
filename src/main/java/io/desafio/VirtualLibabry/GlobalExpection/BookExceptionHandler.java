package io.desafio.VirtualLibabry.GlobalExpection;

import io.desafio.VirtualLibabry.controller.BooksController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice (basePackageClasses = BooksController.class)
public class BookExceptionHandler {
    // Quando os dados não passaram na validação
    @ExceptionHandler (MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationException () {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
    }

    // Quando o corpo da requisição está ausente ou inválido
    @ExceptionHandler (HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleMissingBody () {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}