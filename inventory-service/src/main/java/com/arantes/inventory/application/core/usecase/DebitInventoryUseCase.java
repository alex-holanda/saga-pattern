package com.arantes.inventory.application.core.usecase;

import com.arantes.inventory.application.core.domain.Sale;
import com.arantes.inventory.application.core.domain.enums.SaleEvent;
import com.arantes.inventory.application.ports.in.DebitInventoryInputPort;
import com.arantes.inventory.application.ports.in.FindInventoryByProductIdInputPort;
import com.arantes.inventory.application.ports.out.SendToKafkaOutputPort;
import com.arantes.inventory.application.ports.out.UpdateInventoryOutupPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class DebitInventoryUseCase implements DebitInventoryInputPort {

    private final FindInventoryByProductIdInputPort findInventoryByProductIdInputPort;
    private final UpdateInventoryOutupPort updateInventoryOutupPort;
    private final SendToKafkaOutputPort sendToKafkaOutputPort;

    @Override
    public void debit(Sale sale) {
        try {
            var inventory = findInventoryByProductIdInputPort.find(sale.getProductId());

            if (inventory.getQuantity() < sale.getQuantity())
                throw new RuntimeException("Estoque insuficiente");

            inventory.debitQuantity(sale.getQuantity());
            updateInventoryOutupPort.update(inventory);
            sendToKafkaOutputPort.send(sale, SaleEvent.UPDATED_INVENTORY);
        } catch (Exception e) {
            log.error("Houve um erro = {}", e.getMessage());
            sendToKafkaOutputPort.send(sale, SaleEvent.ROLLBACK_INVENTORY);
        }
    }
}
