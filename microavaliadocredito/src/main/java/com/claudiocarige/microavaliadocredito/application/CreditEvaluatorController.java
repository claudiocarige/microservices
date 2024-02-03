package com.claudiocarige.microavaliadocredito.application;

import com.claudiocarige.microavaliadocredito.domain.model.ClientSituation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/credit-ratings")
public class CreditEvaluatorController {


    private final ClientCreditEvaluatorService clientCreditEvaluatorService;

    public CreditEvaluatorController(ClientCreditEvaluatorService clientCreditEvaluatorService) {
        this.clientCreditEvaluatorService = clientCreditEvaluatorService;
    }

    @GetMapping
    public String status(){
        return "Ok";
    }

    @GetMapping(value = "client-situation", params = "cpf")
    public ResponseEntity<ClientSituation> ClientSituationQuery(@RequestParam("cpf") String cpf){
        ClientSituation clientSituation = clientCreditEvaluatorService.getClientSituation(cpf);
        return ResponseEntity.ok(clientSituation);
    }
}
