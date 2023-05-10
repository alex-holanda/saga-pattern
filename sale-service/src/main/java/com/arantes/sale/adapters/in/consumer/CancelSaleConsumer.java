package com.arantes.sale.adapters.in.consumer;

import com.arantes.sale.adapters.out.message.SaleMessage;
import com.arantes.sale.application.core.domain.enums.SaleEvent;
import com.arantes.sale.application.ports.in.CancelSaleInputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class CancelSaleConsumer {

    private final CancelSaleInputPort cancelSaleInputPort;

    @KafkaListener(topics = "tp-saga-sale", groupId = "sale-cancel")
    public void receive(SaleMessage saleMessage) {
        if (SaleEvent.ROLLBACK_INVENTORY.equals(saleMessage.getSaleEvent())) {
            log.info("Cancelando a venda");
            cancelSaleInputPort.cancel(saleMessage.getSale());
            log.info("Venda cancelada com sucesso");
        }
    }
}
