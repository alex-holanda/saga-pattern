package com.arantes.inventory.application.core.domain;

import com.arantes.inventory.application.core.domain.enums.SaleStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Sale {

    private Integer id;
    private Integer productId;
    private Integer userId;
    private BigDecimal value;
    private SaleStatus status;
    private Integer quantity;
}
