package com.claudiocarige.microavaliadocredito.domain.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CardClient {

    private String cardName;
    private String flag;
    private BigDecimal limitReleased;
}
