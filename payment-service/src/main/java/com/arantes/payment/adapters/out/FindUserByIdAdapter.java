package com.arantes.payment.adapters.out;

import com.arantes.payment.adapters.out.repository.UserRepository;
import com.arantes.payment.adapters.out.repository.mapper.UserEntityMapper;
import com.arantes.payment.application.core.domain.User;
import com.arantes.payment.application.ports.out.FindUserByIdOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindUserByIdAdapter implements FindUserByIdOutputPort {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public Optional<User> find(Integer id) {
        var userEntity = userRepository.findById(id);
        return userEntity.map(userEntityMapper::toUser);
    }
}
