package com.arantes.orchestrator.application.core.domain.enums;

public enum SaleEvent {

    CREATED_SALE,
    CANCEL_SALE,
    FINALIZED_SALE,
    PREPARE_INVENTORY,
    INVENTORY_PREPARED,
    INVENTORY_ERROR,
    EXECUTE_ROLLBACK,
    EXECUTE_PAYMENT,
    PAYMENT_EXECUTED,
    PAYMENT_FAILED

}
