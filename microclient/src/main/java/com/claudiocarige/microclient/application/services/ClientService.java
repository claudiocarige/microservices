package com.claudiocarige.microclient.application.services;

import com.claudiocarige.microclient.domain.Client;
import com.claudiocarige.microclient.infra.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    @Transactional
    public Client insert(Client client){
        return clientRepository.save(client);
    }

    public Optional<Client> getByCpf(String cpf){
        return clientRepository.findByCpf(cpf);
    }
}
