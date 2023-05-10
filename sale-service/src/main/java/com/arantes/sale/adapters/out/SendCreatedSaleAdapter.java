package com.arantes.sale.adapters.out;

import com.arantes.sale.adapters.out.message.SaleMessage;
import com.arantes.sale.application.core.domain.Sale;
import com.arantes.sale.application.core.domain.enums.SaleEvent;
import com.arantes.sale.application.ports.out.SendCreatedSaleOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SendCreatedSaleAdapter implements SendCreatedSaleOutputPort {

    private final KafkaTemplate<String, SaleMessage> kafkaTemplate;

    @Override
    public void send(Sale sale, SaleEvent event) {
        var saleMessage = new SaleMessage();
        saleMessage.setSale(sale);
        saleMessage.setSaleEvent(event);

        kafkaTemplate.send("tp-saga-sale", saleMessage);
    }
}
