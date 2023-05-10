package com.arantes.inventory.application.core.usecase;

import com.arantes.inventory.application.core.domain.Sale;
import com.arantes.inventory.application.core.domain.enums.SaleEvent;
import com.arantes.inventory.application.ports.in.CreditInventoryInputPort;
import com.arantes.inventory.application.ports.in.FindInventoryByProductIdInputPort;
import com.arantes.inventory.application.ports.out.SendToKafkaOutputPort;
import com.arantes.inventory.application.ports.out.UpdateInventoryOutupPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreditInventoryUseCase implements CreditInventoryInputPort {

    private final UpdateInventoryOutupPort updateInventoryOutupPort;
    private final FindInventoryByProductIdInputPort findInventoryByProductIdInputPort;
    private final SendToKafkaOutputPort sendToKafkaOutputPort;

    public void credit(Sale sale) {
        var inventory = findInventoryByProductIdInputPort.find(sale.getProductId());
        inventory.creditQuantity(sale.getQuantity());

        updateInventoryOutupPort.update(inventory);
        sendToKafkaOutputPort.send(sale, SaleEvent.ROLLBACK_INVENTORY);
    }
}
