package com.arantes.sale.application.core.usecase;

import com.arantes.sale.application.core.domain.Sale;
import com.arantes.sale.application.ports.in.FindSaleByIdInputPort;
import com.arantes.sale.application.ports.out.FindSaleByIdOutputPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindSaleByIdUseCase implements FindSaleByIdInputPort {

    private final FindSaleByIdOutputPort findSaleByIdOutputPort;

    @Override
    public Sale find(final Integer id) {
        return findSaleByIdOutputPort.find(id)
                .orElseThrow(() -> new RuntimeException("Venda não encontrada"));
    }
}
