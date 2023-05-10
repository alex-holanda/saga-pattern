package com.arantes.inventory.adapters.out;

import com.arantes.inventory.adapters.out.mapper.InventoryEntityMapper;
import com.arantes.inventory.adapters.out.repository.InventoryRepository;
import com.arantes.inventory.application.core.domain.Inventory;
import com.arantes.inventory.application.ports.out.UpdateInventoryOutupPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateInventoryAdapter implements UpdateInventoryOutupPort {

    private final InventoryRepository inventoryRepository;
    private final InventoryEntityMapper inventoryEntityMapper;

    @Override
    public void update(Inventory inventory) {
        inventoryRepository.save(inventoryEntityMapper.toInventoryEntity(inventory));
    }
}
