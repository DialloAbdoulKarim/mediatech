package com.abdoultech.demo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProduitDto {

    @NotBlank
    private String ref;

    @NotBlank
    private String libelle;

    @NotBlank
    private BigDecimal prix;

    @NotBlank
    private long quantiteStock;

}
