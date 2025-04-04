package com.thiago.scheduler.transaction;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.thiago.scheduler.entities.TransactionEntity;
import com.thiago.scheduler.exceptions.NotFoundException;
import com.thiago.scheduler.repositories.TransactionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionService {

	private final TransactionRepository transactionRepository;

	public Transaction save(Transaction transaction) {
		var transactionEntity = new TransactionEntity(
				null, transaction.getAmount(), transaction.getDate(),
				transaction.getPercentTax(), transaction.getFeeValue(), transaction.getTotal());

		TransactionEntity created = transactionRepository.save(transactionEntity);

		return Transaction.createTransaction(created.getId(), created.getAmount(), created.getDate(),
				created.getPercentTax(), created.getFeeValue(), created.getTotal());
	}

	public Page<Transaction> findAllTransactions(Pageable pageable) {
		Page<TransactionEntity> transactionEntities = transactionRepository.findAll(pageable);
		List<Transaction> transactions = transactionEntities.getContent().stream()
				.map(te -> Transaction.createTransaction(te.getId(), te.getAmount(), te.getDate(),
						te.getPercentTax(), te.getFeeValue(), te.getTotal()))
				.toList();

		return new PageImpl<>(transactions, pageable, transactionEntities.getTotalElements());
	}

	public Transaction findById(Long id) throws NotFoundException {
		TransactionEntity entity = transactionRepository.findById(id)
				.orElseThrow(() -> new NotFoundException());
		return Transaction.createTransaction(entity.getId(), entity.getAmount(), entity.getDate(),
				entity.getPercentTax(), entity.getFeeValue(), entity.getTotal());
	}

	public void delete(Long id) {
		transactionRepository.deleteById(id);
	}

	public void update(Long id, Transaction transaction) throws NotFoundException {
		TransactionEntity entity = transactionRepository.findById(id).orElseThrow(() -> new NotFoundException());
		entity.setAmount(transaction.getAmount());
		entity.setDate(transaction.getDate());
		entity.setPercentTax(transaction.getPercentTax());
		entity.setFeeValue(transaction.getFeeValue());
		entity.setTotal(transaction.getTotal());

		transactionRepository.save(entity);
	}
}
