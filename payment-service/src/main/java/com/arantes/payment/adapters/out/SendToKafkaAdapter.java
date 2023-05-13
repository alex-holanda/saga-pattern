package com.arantes.payment.adapters.out;

import com.arantes.payment.adapters.out.message.SaleMessage;
import com.arantes.payment.application.core.domain.Sale;
import com.arantes.payment.application.core.domain.enums.SaleEvent;
import com.arantes.payment.application.ports.out.SendToKafkaOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SendToKafkaAdapter implements SendToKafkaOutputPort {

    private final KafkaTemplate<String, SaleMessage> kafkaTemplate;

    @Override
    public void send(Sale sale, SaleEvent saleEvent) {
        var saleMessage = new SaleMessage();
        saleMessage.setSale(sale);
        saleMessage.setSaleEvent(saleEvent);

        kafkaTemplate.send("tp-saga-orchestrator", saleMessage);
    }
}
