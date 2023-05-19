package com.claudiocarige.mscartoes.domain;

import com.claudiocarige.mscartoes.domain.enums.CardFlag;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class CardPersonal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private CardFlag flag;
    private BigDecimal income;
    private BigDecimal basicLimit;

    public CardPersonal(String name,
                        CardFlag flag,
                        BigDecimal income,
                        BigDecimal basicLimit) {
        this.name = name;
        this.flag = flag;
        this.income = income;
        this.basicLimit = basicLimit;
    }
}
