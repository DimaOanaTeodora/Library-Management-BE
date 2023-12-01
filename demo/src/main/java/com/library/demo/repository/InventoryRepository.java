package com.library.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.library.demo.model.Inventory;

import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
	
}
