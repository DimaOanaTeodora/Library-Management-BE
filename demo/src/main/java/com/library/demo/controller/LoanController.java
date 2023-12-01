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
import com.library.demo.model.Loan;
import com.library.demo.service.BookService;
import com.library.demo.service.BorrowerService;
import com.library.demo.service.InventoryService;
import com.library.demo.service.LibrarianService;
import com.library.demo.service.LoanService;

@RestController
@RequestMapping("/loans")
public class LoanController {

	private LoanService loanService;
	private BookService bookService;
	private InventoryService inventoryService;
	private LibrarianService librarianService;
	private BorrowerService borrowerService;

	public LoanController(LoanService loanService, BookService bookService, InventoryService inventoryService,
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
	public ResponseEntity<Loan> addLoan(@RequestBody Loan loanRequest) {
		Loan loanResponse = loanService.addLoan(loanRequest);
		return ResponseEntity.ok().body(loanService.getLoan(loanResponse.getId()));
	}

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Loan> getLoan(@PathVariable Integer id) {
		return ResponseEntity.ok().body(loanService.getLoan(id));
	}
}
