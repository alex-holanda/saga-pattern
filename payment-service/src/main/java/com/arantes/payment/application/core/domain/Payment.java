package com.arantes.payment.application.core.domain;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    private Integer id;
    private Integer userId;
    private Integer saleId;
    private BigDecimal value;
}
