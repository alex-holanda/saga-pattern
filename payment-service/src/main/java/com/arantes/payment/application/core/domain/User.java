package com.arantes.payment.application.core.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class User {

    private Integer id;
    private String name;
    private BigDecimal balance;

    public void debitBalance(BigDecimal value) {
        this.balance = this.balance.subtract(value);
    }
}
