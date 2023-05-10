package com.arantes.inventory.application.ports.out;

import com.arantes.inventory.application.core.domain.Sale;
import com.arantes.inventory.application.core.domain.enums.SaleEvent;

public interface SendToKafkaOutputPort {

    void send(Sale sale, SaleEvent event);
}
