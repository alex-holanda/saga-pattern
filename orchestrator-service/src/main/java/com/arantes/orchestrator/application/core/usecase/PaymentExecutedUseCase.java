package com.arantes.orchestrator.application.core.usecase;

import com.arantes.orchestrator.application.core.domain.Sale;
import com.arantes.orchestrator.application.core.domain.enums.SaleEvent;
import com.arantes.orchestrator.application.ports.in.WorkflowInputPort;
import com.arantes.orchestrator.application.ports.out.SendSaleToTopicOutputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class PaymentExecutedUseCase implements WorkflowInputPort {

    private final SendSaleToTopicOutputPort sendSaleToTopicOutputPort;

    @Override
    public void execute(Sale sale) {
        log.info("Finalizando a venda");
        sendSaleToTopicOutputPort.send(sale, SaleEvent.FINALIZED_SALE, "tp-saga-sale");
        log.info("Finalização da venda postada na fila");
    }

    @Override
    public boolean isCalledByTheEvent(SaleEvent saleEvent) {
        return SaleEvent.PAYMENT_EXECUTED.equals(saleEvent);
    }
}
