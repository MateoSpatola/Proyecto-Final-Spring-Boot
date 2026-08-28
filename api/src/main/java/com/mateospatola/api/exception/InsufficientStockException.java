package com.mateospatola.api.exception;

import com.mateospatola.api.dto.error.InsufficientStockItemDTO;
import lombok.Getter;

import java.util.List;

@Getter
public class InsufficientStockException extends RuntimeException {

    private final List<InsufficientStockItemDTO> insufficientStockItems;

    public InsufficientStockException(String message, List<InsufficientStockItemDTO> insufficientStockItems) {
        super(message);
        this.insufficientStockItems = insufficientStockItems;
    }

}
