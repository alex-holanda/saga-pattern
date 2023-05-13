package com.arantes.orchestrator.adapters.out.message;

import com.arantes.orchestrator.application.core.domain.Sale;
import com.arantes.orchestrator.application.core.domain.enums.SaleEvent;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaleMessage {

    private Sale sale;
    private SaleEvent saleEvent;
}
