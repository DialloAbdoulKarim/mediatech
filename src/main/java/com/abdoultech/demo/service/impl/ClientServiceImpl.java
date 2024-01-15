package com.abdoultech.demo.service.impl;

import com.abdoultech.demo.dao.ClientDao;
import com.abdoultech.demo.dto.ClientRequestDto;
import com.abdoultech.demo.dto.ClientResponseDto;
import com.abdoultech.demo.exception.EntityAlreadyExistsException;
import com.abdoultech.demo.exception.EntityNotFoundException;
import com.abdoultech.demo.models.ClientEntity;
import com.abdoultech.demo.service.facade.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.data.crossstore.ChangeSetPersister.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ClientServiceImpl implements ClientService {
    private ClientDao clientDao;
    private ModelMapper modelMapper;

    public ClientServiceImpl(ClientDao clientDao, ModelMapper modelMapper) {
        this.clientDao = clientDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public ClientResponseDto save(ClientRequestDto clientRequestDto) {
        ClientEntity clientEntity = modelMapper.map(clientRequestDto,ClientEntity.class);
        ClientEntity saved = clientDao.save(clientEntity);

        return modelMapper.map(saved, ClientResponseDto.class);
    }

    @Override
    public ClientResponseDto findById(Integer id) {
        ClientEntity clientEntity = clientDao.findById(id).orElseThrow(()-> new EntityAlreadyExistsException("Client not found"));
        return modelMapper.map(clientEntity, ClientResponseDto.class);
    }

    @Override
    public ClientResponseDto findByNom(String nom) {
        ClientEntity clientEntity = clientDao.findByNom(nom);
        return modelMapper.map(clientEntity, ClientResponseDto.class);

    }

    @Override
    public void delete(Integer id) {
        clientDao.deleteById(id);

    }
    //TODO update
    @Override
    public ClientResponseDto update(ClientRequestDto clientRequestDto, Integer id) throws NotFoundException {
        Optional<ClientEntity> clientEntityOptional = clientDao.findById(id);
        if (clientEntityOptional.isPresent()){
            ClientEntity clientEntity = modelMapper.map(clientRequestDto, ClientEntity.class);
            ClientEntity updated = clientDao.save(clientEntity);
            return modelMapper.map(updated, ClientResponseDto.class);
        }else throw new EntityNotFoundException("Client Not Found");

    }
    @Override

    public List<ClientRequestDto> findAll(){
        return clientDao.findAll()
                .stream().map(el -> modelMapper.map(el, ClientRequestDto.class))
                .collect(Collectors.toList());
    }

}
