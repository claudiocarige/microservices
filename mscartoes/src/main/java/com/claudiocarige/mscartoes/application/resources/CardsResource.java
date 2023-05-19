package com.claudiocarige.mscartoes.application.resources;

import com.claudiocarige.mscartoes.application.representation.CardPersonalRepresentation;
import com.claudiocarige.mscartoes.application.services.CardPersonalService;
import com.claudiocarige.mscartoes.domain.CardPersonal;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
public class CardsResource {

    private final CardPersonalService cardPersonalService;
    @GetMapping
    public String status(){
        return "Cartões ok";
    }

    @PostMapping
    public ResponseEntity<CardPersonal> insert(@RequestBody CardPersonalRepresentation cardRepresentation){
        CardPersonal cardpersonal = cardRepresentation.toModel();
        cardPersonalService.insert(cardpersonal);
       return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
