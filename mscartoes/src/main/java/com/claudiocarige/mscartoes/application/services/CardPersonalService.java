package com.claudiocarige.mscartoes.application.services;

import com.claudiocarige.mscartoes.domain.CardPersonal;
import com.claudiocarige.mscartoes.infra.repository.CardPersonalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardPersonalService {

    private final CardPersonalRepository cardPersonalRepository;

    @Transactional
    public CardPersonal insert(CardPersonal cardPersonal){
        return cardPersonalRepository.save(cardPersonal);
    }
    public List<CardPersonal> getCardsPersonalLessEqual(Long income){
        var incomeBigDecimal = BigDecimal.valueOf(income);
        return  cardPersonalRepository.findByIncomeLessThanEqual(income);
    }
}
