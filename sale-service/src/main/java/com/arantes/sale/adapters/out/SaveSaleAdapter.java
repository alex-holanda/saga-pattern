package com.arantes.sale.adapters.out;

import com.arantes.sale.adapters.out.repository.SaleRepository;
import com.arantes.sale.adapters.out.repository.mapper.SaleEntityMapper;
import com.arantes.sale.application.core.domain.Sale;
import com.arantes.sale.application.ports.out.SaveSaleOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveSaleAdapter implements SaveSaleOutputPort {

    private final SaleRepository saleRepository;
    private final SaleEntityMapper saleEntityMapper;

    @Override
    public Sale save(Sale sale) {
        var saleEntity = saleEntityMapper.toSaleEntity(sale);
        var saleEntityResponse = saleRepository.save(saleEntity);
        return saleEntityMapper.toSale(saleEntityResponse);
    }
}
