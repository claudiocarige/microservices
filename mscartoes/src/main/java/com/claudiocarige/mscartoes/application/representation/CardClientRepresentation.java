package com.claudiocarige.mscartoes.application.representation;

import com.claudiocarige.mscartoes.domain.CardClient;
import com.claudiocarige.mscartoes.domain.CardPersonal;
import com.claudiocarige.mscartoes.domain.enums.CardFlag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardClientRepresentation {

    private String name;
    private CardFlag flag;
    private BigDecimal basicLimit;

    public static CardClientRepresentation fromRepresentation(CardClient cardClient){
        return new CardClientRepresentation(
                cardClient.getCardPersonal().getName(),
                cardClient.getCardPersonal().getFlag(),
                cardClient.getApprovedLimit()
        );
    }

}
