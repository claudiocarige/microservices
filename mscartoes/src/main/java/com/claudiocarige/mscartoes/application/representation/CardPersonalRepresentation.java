package com.claudiocarige.mscartoes.application.representation;

import com.claudiocarige.mscartoes.domain.CardPersonal;
import com.claudiocarige.mscartoes.domain.enums.CardFlag;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CardPersonalRepresentation {

    private String name;
    private CardFlag flag;
    private BigDecimal income;
    private BigDecimal basicLimit;

    public CardPersonal toModel(){
        return new CardPersonal(name, flag, income, basicLimit);
    }
}
