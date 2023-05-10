package com.arantes.inventory.adapters.out.mapper;

import com.arantes.inventory.adapters.out.repository.InventoryRepository;
import com.arantes.inventory.adapters.out.repository.entity.InventoryEntity;
import com.arantes.inventory.application.core.domain.Inventory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InventoryEntityMapper {

    Inventory toInventory(InventoryEntity inventoryEntity);

    InventoryEntity toInventoryEntity(Inventory inventory);
}
