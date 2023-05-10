package com.arantes.sale.adapters.out;

import com.arantes.sale.adapters.out.repository.SaleRepository;
import com.arantes.sale.adapters.out.repository.mapper.SaleEntityMapper;
import com.arantes.sale.application.core.domain.Sale;
import com.arantes.sale.application.ports.out.FindSaleByIdOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindSaleByIdAdapter implements FindSaleByIdOutputPort {

    private final SaleRepository saleRepository;
    private final SaleEntityMapper saleEntityMapper;

    @Override
    public Optional<Sale> find(Integer id) {
        var saleEntity = saleRepository.findById(id);
        return saleEntity.map(saleEntityMapper::toSale);
    }
}
