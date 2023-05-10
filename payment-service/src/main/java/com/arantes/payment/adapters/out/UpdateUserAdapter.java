package com.arantes.payment.adapters.out;

import com.arantes.payment.adapters.out.repository.UserRepository;
import com.arantes.payment.adapters.out.repository.mapper.UserEntityMapper;
import com.arantes.payment.application.core.domain.User;
import com.arantes.payment.application.ports.out.UpdateUserOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateUserAdapter implements UpdateUserOutputPort {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public void update(User user) {
        var userEntity = userEntityMapper.toUserEntity(user);
        userRepository.save(userEntity);
    }
}
