package com.abdoultech.demo.service.facade;

import com.abdoultech.demo.dto.ClientRequestDto;
import com.abdoultech.demo.dto.ClientResponseDto;
import org.springframework.data.crossstore.ChangeSetPersister.*;

import java.util.List;

public interface ClientService {

    ClientResponseDto save(ClientRequestDto clientRequestDto);


    ClientResponseDto findById(Integer id);


    ClientResponseDto findByNom(String nom);

    void delete(Integer id);


    ClientResponseDto update(ClientRequestDto clientRequestDto, Integer id) throws NotFoundException;

    List<ClientRequestDto> findAll();



}
