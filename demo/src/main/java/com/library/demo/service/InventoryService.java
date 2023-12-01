package com.library.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.library.demo.model.Inventory;
import com.library.demo.repository.InventoryRepository;
import com.library.demo.repository.BorrowerRepository;
import com.library.demo.repository.InventoryRepository;
import com.library.demo.repository.LibrarianRepository;
import com.library.demo.repository.LoanRepository;

@Service
public class InventoryService {
	private LoanRepository loanRepository;
	private LibrarianRepository librarianRepository;
	private InventoryRepository inventoryRepository;
	private BorrowerRepository borrowerRepository;
	private InventoryRepository bookRepository;

	public InventoryService(LoanRepository loanRepository, LibrarianRepository librarianRepository,
			InventoryRepository inventoryRepository, BorrowerRepository borrowerRepository,
			InventoryRepository bookRepository) {
		super();
		this.loanRepository = loanRepository;
		this.librarianRepository = librarianRepository;
		this.inventoryRepository = inventoryRepository;
		this.borrowerRepository = borrowerRepository;
		this.bookRepository = bookRepository;
	}

	public Inventory addInventory(Inventory inventoryRequest) {
		return inventoryRepository.save(inventoryRequest);
	}

	public Inventory getInventory(Integer id) {
		Optional<Inventory> inventoryOptional = inventoryRepository.findById(id);
		if (inventoryOptional.isPresent()) {
			return inventoryOptional.get();
		} else {
			throw new RuntimeException("Inventory with id " + id + " doesn't exist ");
		}
	}
}
