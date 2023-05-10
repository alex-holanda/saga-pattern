package com.arantes.sale.application.core.usecase;

import com.arantes.sale.application.core.domain.Sale;
import com.arantes.sale.application.core.domain.enums.SaleStatus;
import com.arantes.sale.application.ports.in.FinalizeSaleInputPort;
import com.arantes.sale.application.ports.in.FindSaleByIdInputPort;
import com.arantes.sale.application.ports.out.SaveSaleOutputPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FinalizeSaleUseCase implements FinalizeSaleInputPort {

    private final FindSaleByIdInputPort findSaleByIdInputPort;
    private final SaveSaleOutputPort saveSaleOutputPort;

    @Override
    public void finalize(Sale sale) {
        var saleResponse = findSaleByIdInputPort.find(sale.getId());
        saleResponse.setStatus(SaleStatus.FINALIZED);
        saveSaleOutputPort.save(saleResponse);
    }
}
