package com.arantes.inventory.adapters.in.consumer;

import com.arantes.inventory.adapters.out.message.SaleMessage;
import com.arantes.inventory.application.core.domain.enums.SaleEvent;
import com.arantes.inventory.application.ports.in.DebitInventoryInputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ReceiveSaleToDebitInventoryConsumer {

    private final DebitInventoryInputPort debitInventoryInputPort;

    @KafkaListener(topics = "tp-saga-inventory", groupId = "inventory-debit")
    public void receive(SaleMessage saleMessage) {
        if (SaleEvent.PREPARE_INVENTORY.equals(saleMessage.getSaleEvent())) {
            log.info("Inicio da separacao de mercadoria.");
            debitInventoryInputPort.debit(saleMessage.getSale());
            log.info("Fim da separação de mercadoria.");
        }
    }
}
