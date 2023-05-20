package com.claudiocarige.mscartoes.application.services;

import com.claudiocarige.mscartoes.application.representation.CardClientRepresentation;
import com.claudiocarige.mscartoes.domain.CardClient;
import com.claudiocarige.mscartoes.infra.repository.CardClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardClientService {

    private final CardClientRepository cardClientRepository;

    public List<CardClient> findByCpf(String cpf){
        return cardClientRepository.findByCpf(cpf);
    }
}
