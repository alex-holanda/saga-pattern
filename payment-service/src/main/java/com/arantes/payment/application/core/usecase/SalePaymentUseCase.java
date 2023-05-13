package com.arantes.payment.application.core.usecase;

import com.arantes.payment.application.core.domain.Payment;
import com.arantes.payment.application.core.domain.Sale;
import com.arantes.payment.application.core.domain.enums.SaleEvent;
import com.arantes.payment.application.ports.in.FindUserByIdInputPort;
import com.arantes.payment.application.ports.in.SalePaymentInputPort;
import com.arantes.payment.application.ports.out.SavePaymentOutputPort;
import com.arantes.payment.application.ports.out.SendToKafkaOutputPort;
import com.arantes.payment.application.ports.out.UpdateUserOutputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class SalePaymentUseCase implements SalePaymentInputPort {

    private final FindUserByIdInputPort findUserByIdInputPort;
    private final UpdateUserOutputPort updateUserOutputPort;
    private final SavePaymentOutputPort savePaymentOutputPort;
    private final SendToKafkaOutputPort sendToKafkaOutputPort;

    @Override
    public void payment(Sale sale) {
        try {
            var user = findUserByIdInputPort.find(sale.getUserId());

            if (user.getBalance().compareTo(sale.getValue()) < 0) {
                throw new RuntimeException("Saldo insuficiente");
            }
            user.debitBalance(sale.getValue());

            updateUserOutputPort.update(user);
            savePaymentOutputPort.save(buildPayment(sale));
            sendToKafkaOutputPort.send(sale, SaleEvent.PAYMENT_EXECUTED);
        } catch (Exception e) {
            log.error("Houve um erro = {}", e.getMessage());
            sendToKafkaOutputPort.send(sale, SaleEvent.PAYMENT_FAILED);
        }
    }

    private Payment buildPayment(Sale sale) {
        return Payment.builder()
                .userId(sale.getUserId())
                .saleId(sale.getId())
                .value(sale.getValue())
                .build();
    }
}
