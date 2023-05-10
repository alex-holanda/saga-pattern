package com.arantes.inventory.application.core.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Inventory {

    private Integer id;

    private Integer productId;

    private Integer quantity;

    public void debitQuantity(Integer quantity) {
        this.quantity -= quantity;
    }

    public void creditQuantity(Integer quantity) {
        this.quantity += quantity;
    }
}
