package com.arantes.inventory.adapters.out;

import com.arantes.inventory.adapters.out.message.SaleMessage;
import com.arantes.inventory.application.core.domain.Sale;
import com.arantes.inventory.application.core.domain.enums.SaleEvent;
import com.arantes.inventory.application.ports.out.SendToKafkaOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SendToKafkaAdapter implements SendToKafkaOutputPort {

    private final KafkaTemplate<String, SaleMessage> kafkaTemplate;

    @Override
    public void send(Sale sale, SaleEvent event) {
        var saleMessage = SaleMessage.builder().sale(sale).saleEvent(event).build();
        kafkaTemplate.send("tp-saga-orchestrator", saleMessage);
    }
}
