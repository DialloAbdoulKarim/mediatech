package com.abdoultech.demo.controllers;

import com.abdoultech.demo.dto.ClientRequestDto;
import com.abdoultech.demo.dto.ClientResponseDto;
import com.abdoultech.demo.service.facade.ClientService;
import jakarta.validation.Valid;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("clients")
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("")
    public ResponseEntity<List<ClientRequestDto>> getClient() {

        return new ResponseEntity<>(clientService.findAll(), HttpStatus.OK);
    }

//ResponeEntity pour personaliser les serveurs Http
    @PostMapping("/")

    public ResponseEntity<ClientResponseDto> save(@Valid @RequestBody() ClientRequestDto clientRequestDto){
        ClientResponseDto clientResponseDto = clientService.save(clientRequestDto);
        return new ResponseEntity<>(clientResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/id/{id}")

    public ResponseEntity<ClientResponseDto> findById(@PathVariable("id") Integer id) {
        ClientResponseDto clientResponseDto = clientService.findById(id);
        return ResponseEntity.ok(clientResponseDto);
    }


    @GetMapping("nom/{nom}")

    public ResponseEntity<ClientResponseDto> findByNom(@PathVariable() String nom) {
        ClientResponseDto clientResponseDto = clientService.findByNom(nom);

        return ResponseEntity.ok(clientResponseDto);
    }

    @DeleteMapping("id/{id}")
    public ResponseEntity<?> delete( @PathVariable() Integer id) {
        clientService.delete(id);

       return ResponseEntity.noContent().build();
    }


    @PutMapping("id/{id}")
    public ResponseEntity<ClientResponseDto> update(@Valid @RequestBody() ClientRequestDto clientRequestDto, @PathVariable() Integer id) throws ChangeSetPersister.NotFoundException {
        ClientResponseDto clientResponseDto = clientService.update(clientRequestDto, id);
        return ResponseEntity.accepted().body(clientResponseDto);
    }
}


