package com.example.DesafioItau.controllers;

import com.example.DesafioItau.dtos.TransactionDTO;
import com.example.DesafioItau.models.Transaction;
import com.example.DesafioItau.service.TransactionService;
import jakarta.validation.Valid;

import com.example.DesafioItau.dtos.statisticsDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@Valid @RequestBody TransactionDTO transactionDTO) {

        Transaction transaction = new Transaction();
        transaction.setValor(transactionDTO.getValor());
        transaction.setDataHora(transactionDTO.getDataHora());

        Transaction createdTransaction = transactionService.createTransaction(transaction);
        return new ResponseEntity<>(createdTransaction, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<statisticsDTO> getStatistics() {
        statisticsDTO statistics = transactionService.getStatistics();
        return ResponseEntity.ok(statistics);
    }
}
