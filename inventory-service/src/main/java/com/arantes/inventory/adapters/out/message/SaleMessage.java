package com.arantes.inventory.adapters.out.message;

import com.arantes.inventory.application.core.domain.Sale;
import com.arantes.inventory.application.core.domain.enums.SaleEvent;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleMessage {

    private Sale sale;
    private SaleEvent saleEvent;
}
