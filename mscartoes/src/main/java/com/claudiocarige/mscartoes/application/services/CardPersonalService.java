package com.claudiocarige.mscartoes.application.services;

import com.claudiocarige.mscartoes.domain.CardClient;
import com.claudiocarige.mscartoes.domain.CardPersonal;
import com.claudiocarige.mscartoes.infra.repository.CardClientRepository;
import com.claudiocarige.mscartoes.infra.repository.CardPersonalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardPersonalService {

    private final CardPersonalRepository cardPersonalRepository;
    private final CardClientRepository cardClientRepository;

    @Transactional
    public CardPersonal insert(CardPersonal cardPersonal){
        return cardPersonalRepository.save(cardPersonal);
    }
    public List<CardPersonal> getCardsPersonalLessEqual(Long income){
        var incomeBigDecimal = BigDecimal.valueOf(income);
        return  cardPersonalRepository.findByIncomeLessThanEqual(incomeBigDecimal);
    }

}
