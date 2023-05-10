package com.arantes.inventory.config.usecase;

import com.arantes.inventory.adapters.out.SendToKafkaAdapter;
import com.arantes.inventory.adapters.out.UpdateInventoryAdapter;
import com.arantes.inventory.application.core.usecase.CreditInventoryUseCase;
import com.arantes.inventory.application.core.usecase.FindInventoryByProductIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreditInventoryConfig {

    @Bean
    public CreditInventoryUseCase creditInventoryUseCase(
            FindInventoryByProductIdUseCase inventoryByProductIdUseCase,
            UpdateInventoryAdapter updateInventoryAdapter,
            SendToKafkaAdapter sendToKafkaAdapter
    ) {
        return new CreditInventoryUseCase(updateInventoryAdapter, inventoryByProductIdUseCase, sendToKafkaAdapter);
    }
}
