package com.claudiocarige.microclient.application.resouces;

import com.claudiocarige.microclient.application.representation.ClientSaveRequest;
import com.claudiocarige.microclient.application.services.ClientService;
import com.claudiocarige.microclient.domain.Client;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Random;

@RestController
@RequestMapping("clients")
@RequiredArgsConstructor
@Slf4j
public class ClientResource {

    private final ClientService clientService;

    @GetMapping
    public String status(){
        //Teste de Balanceamento
        Random random = new Random();
        int randomNumber = random.nextInt(100);
        log.info("Obtendo status do Microservice do Cliente. " + randomNumber);
        return "ok";
    }

    @PostMapping
    public ResponseEntity<Client> insert(@RequestBody ClientSaveRequest clientRequest){
        //Teste de Balanceamento
        Random random = new Random();
        int randomNumber = random.nextInt(100);
        log.info("STATUS de POST do Cliente. " + randomNumber);

        var client = clientRequest.toModel();
        clientService.insert(client);
        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(client.getCpf())
                .toUri();

         return ResponseEntity.created(headerLocation).build();
    }
    @GetMapping(params = "cpf")
    public ResponseEntity findByCpf(@RequestParam String cpf){
        var client = clientService.getByCpf(cpf);
        if(client.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(client);
    }
}

