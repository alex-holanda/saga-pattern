package com.arantes.sale.adapters.out.repository;

import com.arantes.sale.adapters.out.repository.entity.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<SaleEntity, Integer> {
}
