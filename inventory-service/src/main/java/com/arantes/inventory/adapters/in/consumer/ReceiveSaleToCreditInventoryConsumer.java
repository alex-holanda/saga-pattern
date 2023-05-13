package com.arantes.inventory.adapters.in.consumer;

import com.arantes.inventory.adapters.out.message.SaleMessage;
import com.arantes.inventory.application.core.domain.enums.SaleEvent;
import com.arantes.inventory.application.ports.in.CreditInventoryInputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ReceiveSaleToCreditInventoryConsumer {

    private final CreditInventoryInputPort creditInventoryInputPort;

    @KafkaListener(topics = "tp-saga-inventory", groupId = "inventory-credit")
    public void receve(SaleMessage saleMessage) {
        if (SaleEvent.EXECUTE_ROLLBACK.equals(saleMessage.getSaleEvent())) {
            log.info("Inicio da devolução da mercadoria");
            creditInventoryInputPort.credit(saleMessage.getSale());
            log.info("Fim da devolução da mercadoria");
        }
    }
}
