package com.arantes.sale.adapters.out.message;

import com.arantes.sale.application.core.domain.Sale;
import com.arantes.sale.application.core.domain.enums.SaleEvent;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SaleMessage {

    private Sale sale;
    private SaleEvent saleEvent;
}
