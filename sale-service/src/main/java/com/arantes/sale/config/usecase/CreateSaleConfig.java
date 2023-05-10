package com.arantes.sale.config.usecase;

import com.arantes.sale.adapters.out.SaveSaleAdapter;
import com.arantes.sale.adapters.out.SendCreatedSaleAdapter;
import com.arantes.sale.application.core.usecase.CreateSaleUseCase;
import com.arantes.sale.application.ports.out.SaveSaleOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateSaleConfig {

    @Bean
    public CreateSaleUseCase createSaleUseCase(
            SaveSaleAdapter saveSaleAdapter,
            SendCreatedSaleAdapter sendCreatedSaleAdapter
    ) {
        return new CreateSaleUseCase(saveSaleAdapter, sendCreatedSaleAdapter);
    }
}
