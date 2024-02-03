package com.claudiocarige.microavaliadocredito.application;

import com.claudiocarige.microavaliadocredito.domain.model.ClientData;
import com.claudiocarige.microavaliadocredito.domain.model.ClientSituation;
import com.claudiocarige.microavaliadocredito.infra.ClientResourceClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClientCreditEvaluatorService {

    private final ClientResourceClient clientClient;

    public ClientCreditEvaluatorService(ClientResourceClient clientClient) {
        this.clientClient = clientClient;
    }

    public ClientSituation getClientSituation(String cpf) {
        //Obter dados do cliente fazendo requisição para outro microserviço.
        ResponseEntity<ClientData> dataClientResponseEntity = clientClient.findByCpf(cpf);
        //Obter cartões do cliente
        return ClientSituation
                .builder()
                .clientData(dataClientResponseEntity.getBody())
                .build();
    }
}
