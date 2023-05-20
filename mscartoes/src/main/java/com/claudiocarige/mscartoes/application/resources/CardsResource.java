package com.claudiocarige.mscartoes.application.resources;

import com.claudiocarige.mscartoes.application.representation.CardClientRepresentation;
import com.claudiocarige.mscartoes.application.representation.CardPersonalRepresentation;
import com.claudiocarige.mscartoes.application.services.CardClientService;
import com.claudiocarige.mscartoes.application.services.CardPersonalService;
import com.claudiocarige.mscartoes.domain.CardClient;
import com.claudiocarige.mscartoes.domain.CardPersonal;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
public class CardsResource {

    private final CardPersonalService cardPersonalService;
    private final CardClientService cardClientService;

    @PostMapping
    public ResponseEntity<CardPersonal> insert(@RequestBody CardPersonalRepresentation cardRepresentation) {
        CardPersonal cardpersonal = cardRepresentation.toModel();
        cardPersonalService.insert(cardpersonal);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "income")
    public ResponseEntity<List<CardPersonalRepresentation>> findByIncomeLess(@RequestParam("income") Long income) {
        List<CardPersonal> list = cardPersonalService.getCardsPersonalLessEqual(income);
        List<CardPersonalRepresentation> listRepresentation = list.stream()
                .map(x -> new CardPersonalRepresentation(x))
                .collect(Collectors.toList());
        ;
        return ResponseEntity.ok().body(listRepresentation);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<CardClientRepresentation>> findCardByCpf(@RequestParam("cpf") String cpf) {
        List<CardClient> list = cardClientService.findByCpf(cpf);
        List<CardClientRepresentation> listRepresentation = list.stream()
                .map(CardClientRepresentation::fromRepresentation)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(listRepresentation);
    }
}
