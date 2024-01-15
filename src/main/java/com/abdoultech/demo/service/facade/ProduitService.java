package com.abdoultech.demo.service.facade;

import com.abdoultech.demo.dto.ProduitDto;

import java.util.List;

public interface ProduitService {

ProduitDto save(ProduitDto produitDto);

int delete(String ref);

ProduitDto update(ProduitDto produitDto);

ProduitDto findByRef(String ref);


    List<ProduitDto> findAll();
}
