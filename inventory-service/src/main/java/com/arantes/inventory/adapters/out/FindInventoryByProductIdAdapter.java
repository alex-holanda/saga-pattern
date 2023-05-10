package com.arantes.inventory.adapters.out;

import com.arantes.inventory.adapters.out.mapper.InventoryEntityMapper;
import com.arantes.inventory.adapters.out.repository.InventoryRepository;
import com.arantes.inventory.application.core.domain.Inventory;
import com.arantes.inventory.application.ports.out.FindInventoryByProductIdOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindInventoryByProductIdAdapter implements FindInventoryByProductIdOutputPort {

    private final InventoryRepository inventoryRepository;
    private final InventoryEntityMapper inventoryEntityMapper;

    @Override
    public Optional<Inventory> find(Integer productId) {
        var inventoryEntity = inventoryRepository.findByProductId(productId);

        return inventoryEntity.map(inventoryEntityMapper::toInventory);
    }
}
