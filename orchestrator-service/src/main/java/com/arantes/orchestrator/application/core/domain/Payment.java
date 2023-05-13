package com.arantes.orchestrator.application.core.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Payment {

    private Integer id;
    private Integer userId;
    private Integer saleId;
    private BigDecimal value;
}
