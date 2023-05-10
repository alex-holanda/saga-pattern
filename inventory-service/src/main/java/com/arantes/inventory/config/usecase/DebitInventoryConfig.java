package com.arantes.inventory.config.usecase;

import com.arantes.inventory.application.core.usecase.DebitInventoryUseCase;
import com.arantes.inventory.application.core.usecase.FindInventoryByProductIdUseCase;
import com.arantes.inventory.application.ports.out.SendToKafkaOutputPort;
import com.arantes.inventory.application.ports.out.UpdateInventoryOutupPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DebitInventoryConfig {

    @Bean
    public DebitInventoryUseCase debitInventoryUseCase(
            FindInventoryByProductIdUseCase inventoryByProductIdUseCase,
            UpdateInventoryOutupPort updateInventoryOutupPort,
            SendToKafkaOutputPort sendToKafkaOutputPort
    ) {
        return new DebitInventoryUseCase(inventoryByProductIdUseCase, updateInventoryOutupPort, sendToKafkaOutputPort);
    }
}
