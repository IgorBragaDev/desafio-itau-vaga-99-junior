package com.example.DesafioItau.service;

import com.example.DesafioItau.models.Transaction;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    public Transaction createTransaction(Transaction transaction) {
        return transaction; // Retorna a transação recebida
    }
}