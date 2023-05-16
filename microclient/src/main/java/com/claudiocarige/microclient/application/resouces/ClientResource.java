package com.claudiocarige.microclient.application;

import com.claudiocarige.microclient.domain.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
    @GetMapping
    public String status(){
        return "ok";
    }

    @PostMapping
    public ResponseEntity<Client> insert(@RequestBody Client client){
         
    }

}

