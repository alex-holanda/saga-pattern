package com.arantes.payment.application.core.usecase;

import com.arantes.payment.application.core.domain.User;
import com.arantes.payment.application.ports.in.FindUserByIdInputPort;
import com.arantes.payment.application.ports.out.FindUserByIdOutputPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindUserByIdUseCase implements FindUserByIdInputPort {

    private final FindUserByIdOutputPort findUserByIdOutputPort;

    public User find(final Integer id) {
        return findUserByIdOutputPort.find(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }
}
