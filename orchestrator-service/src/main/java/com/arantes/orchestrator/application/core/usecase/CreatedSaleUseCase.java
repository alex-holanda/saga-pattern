package com.arantes.orchestrator.application.core.usecase;

import com.arantes.orchestrator.application.core.domain.Sale;
import com.arantes.orchestrator.application.core.domain.enums.SaleEvent;
import com.arantes.orchestrator.application.ports.in.WorkflowInputPort;
import com.arantes.orchestrator.application.ports.out.SendSaleToTopicOutputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class CreatedSaleUseCase implements WorkflowInputPort {

    private final SendSaleToTopicOutputPort sendSaleToTopicOutputPort;

    @Override
    public void execute(Sale sale) {
        log.info("Início da separação do estoque");
        sendSaleToTopicOutputPort.send(sale, SaleEvent.PREPARE_INVENTORY, "tp-saga-inventory");
        log.info("Enviando para fila da separação do estoque");
    }

    @Override
    public boolean isCalledByTheEvent(SaleEvent saleEvent) {
        return SaleEvent.CREATED_SALE.equals(saleEvent);
    }
}
