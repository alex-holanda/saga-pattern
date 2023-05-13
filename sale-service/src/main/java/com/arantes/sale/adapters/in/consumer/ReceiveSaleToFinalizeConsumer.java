package com.arantes.sale.adapters.in.consumer;

import com.arantes.sale.adapters.out.message.SaleMessage;
import com.arantes.sale.application.core.domain.enums.SaleEvent;
import com.arantes.sale.application.ports.in.FinalizeSaleInputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ReceiveSaleToFinalizeConsumer {

    private final FinalizeSaleInputPort finalizeSaleInputPort;

    @KafkaListener(topics = "tp-saga-sale", groupId = "sale-finalize")
    public void receive(SaleMessage saleMessage) {
        if (SaleEvent.FINALIZED_SALE.equals(saleMessage.getSaleEvent())) {
            log.info("Finalizando a venda");
            finalizeSaleInputPort.finalize(saleMessage.getSale());
            log.info("Venda finalizada com sucesso");
        }
    }

}
