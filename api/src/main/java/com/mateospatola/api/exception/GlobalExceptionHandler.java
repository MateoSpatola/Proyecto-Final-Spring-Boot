package com.mateospatola.api.exception;

import com.mateospatola.api.dto.error.ErrorResponseDTO;
import com.mateospatola.api.dto.error.InsufficientStockResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleNotFound(NotFoundException ex) {
        ErrorResponseDTO error = new ErrorResponseDTO(404, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(InsufficientStockException.class)
    public ResponseEntity<InsufficientStockResponseDTO> handleInsufficientStock(InsufficientStockException ex) {
        InsufficientStockResponseDTO error = new InsufficientStockResponseDTO(409, ex.getMessage(), ex.getInsufficientStockItems());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

}