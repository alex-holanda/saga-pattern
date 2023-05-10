package com.arantes.payment.adapters.out.message;

import com.arantes.payment.application.core.domain.Sale;
import com.arantes.payment.application.core.domain.enums.SaleEvent;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaleMessage {

    private Sale sale;
    private SaleEvent saleEvent;
}
