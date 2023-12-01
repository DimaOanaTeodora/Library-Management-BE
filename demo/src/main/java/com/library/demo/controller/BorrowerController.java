package com.library.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.demo.model.Book;
import com.library.demo.model.Borrower;
import com.library.demo.service.BookService;
import com.library.demo.service.BorrowerService;
import com.library.demo.service.InventoryService;
import com.library.demo.service.LibrarianService;
import com.library.demo.service.LoanService;

@RestController
@RequestMapping("/borrowers")
public class BorrowerController {

	private LoanService loanService;
	private BookService bookService;
	private InventoryService inventoryService;
	private LibrarianService librarianService;
	private BorrowerService borrowerService;

	public BorrowerController(LoanService loanService, BookService bookService, InventoryService inventoryService,
			LibrarianService librarianService, BorrowerService borrowerService) {
		super();
		this.loanService = loanService;
		this.bookService = bookService;
		this.inventoryService = inventoryService;
		this.librarianService = librarianService;
		this.borrowerService = borrowerService;
	}

	@PostMapping(path = "/add", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Borrower> addBorrower(@RequestBody Borrower borrowerRequest) {
		Borrower borrowerResponse = borrowerService.addBorrower(borrowerRequest);
		return ResponseEntity.ok().body(borrowerService.getBorrower(borrowerResponse.getId()));
	}

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Borrower> getBorrower(@PathVariable Integer id) {
		return ResponseEntity.ok().body(borrowerService.getBorrower(id));
	}

}
