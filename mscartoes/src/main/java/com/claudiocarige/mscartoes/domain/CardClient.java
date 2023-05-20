package com.claudiocarige.mscartoes.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class CardClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    @ManyToOne
    @JoinColumn(name = "id_card_personal")
    private CardPersonal cardPersonal;
    private BigDecimal approvedLimit;

    public CardClient(String name, String cpf, CardPersonal cardPersonal, BigDecimal approvedLimit) {
        this.name = name;
        this.cpf = cpf;
        this.cardPersonal = cardPersonal;
        this.approvedLimit = approvedLimit;
    }
}
