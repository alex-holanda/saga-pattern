package com.arantes.payment.adapters.out;

import com.arantes.payment.adapters.out.repository.PaymentRepository;
import com.arantes.payment.adapters.out.repository.mapper.PaymentEntityMapper;
import com.arantes.payment.application.core.domain.Payment;
import com.arantes.payment.application.ports.out.SavePaymentOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SavePaymentAdapter implements SavePaymentOutputPort {

    private final PaymentRepository paymentRepository;
    private final PaymentEntityMapper paymentEntityMapper;

    @Override
    public void save(Payment payment) {
        var paymentEntity = paymentEntityMapper.toPaymentEntity(payment);
        paymentRepository.save(paymentEntity);
    }
}
