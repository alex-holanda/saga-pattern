package com.arantes.payment.adapters.in.consumer;

import com.arantes.payment.adapters.out.message.SaleMessage;
import com.arantes.payment.application.core.domain.enums.SaleEvent;
import com.arantes.payment.application.ports.in.SalePaymentInputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ReceiveSaleToPaymentConsumer {

    private final SalePaymentInputPort salePaymentInputPort;

    @KafkaListener(topics = "tp-saga-sale", groupId = "payment")
    public void receive(SaleMessage saleMessage) {
        if (SaleEvent.UPDATED_INVENTORY.equals(saleMessage.getSaleEvent())) {
            log.info("Inicio do pagamento");
            salePaymentInputPort.payment(saleMessage.getSale());
            log.info("Fim do pagamento");
        }
    }
}
