package com.claudiocarige.mscartoes.application.representation;

import com.claudiocarige.mscartoes.domain.CardPersonal;
import com.claudiocarige.mscartoes.domain.enums.CardFlag;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class CardPersonalRepresentation {

    private String name;
    private CardFlag flag;
    private BigDecimal income;
    private BigDecimal basicLimit;

    public CardPersonalRepresentation(CardPersonal cardPersonal){
        this.name = cardPersonal.getName();
        this.flag = cardPersonal.getFlag();
        this.income = cardPersonal.getIncome();
        this.basicLimit = cardPersonal.getBasicLimit();
    }
    public CardPersonal toModel(){
        return new CardPersonal(name, flag, income, basicLimit);
    }
}
