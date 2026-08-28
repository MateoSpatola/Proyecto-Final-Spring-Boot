package com.mateospatola.api.dto.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class InsufficientStockResponseDTO {
    private int status;
    private String message;
    private List<InsufficientStockItemDTO> productos;
}
