package com.thiago.scheduler.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thiago.scheduler.exceptions.NotFoundException;
import com.thiago.scheduler.transaction.Transaction;
import com.thiago.scheduler.transaction.TransactionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/v1/transactions")
@RequiredArgsConstructor
public class TransactionController {

	private final TransactionService transactionService;

	@PostMapping
	public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
		Transaction createdTransaction = transactionService.save(transaction);
		return new ResponseEntity<>(createdTransaction, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<Page<Transaction>> getTransactions(Pageable pageable) {
		return new ResponseEntity<>(transactionService.findAllTransactions(pageable), HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Transaction> getTransaction(@PathVariable Long id) {
		try {
			Transaction transaction = transactionService.findById(id);
			return new ResponseEntity<>(transaction, HttpStatus.OK);
		} catch (NotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
