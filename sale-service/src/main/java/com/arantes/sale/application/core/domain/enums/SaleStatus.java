package com.arantes.sale.application.core.domain.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@Getter
public enum SaleStatus {

    PENDING(1),
    FINALIZED(2),

    CANCELED(3);


    private final Integer statusId;

    SaleStatus(Integer statusId) {
        this.statusId = statusId;
    }

    public static SaleStatus toEnum(Integer id) {
        if (Objects.isNull(id)) return null;

        return Arrays.stream(SaleStatus.values())
                .filter(saleStatus -> id.equals(saleStatus.getStatusId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("ID '%s' do status é inválido", id)));
    }
}
