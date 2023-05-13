package com.arantes.orchestrator.application.core.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Inventory {

    private Integer id;
    private Integer productId;
    private Integer quantity;
}
