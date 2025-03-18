package com.example.DesafioItau.service;

import com.example.DesafioItau.models.Transaction;
import org.springframework.stereotype.Service;

import com.example.DesafioItau.dtos.statisticsDTO;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {
    private final List<Transaction> transactions = new ArrayList<>();
    

    public Transaction createTransaction(Transaction transaction) {
        transactions.add(transaction);
        return transaction; 

    }

    public List<Transaction> getAllTransactions() {
        return Collections.unmodifiableList(transactions);
    }

    public statisticsDTO getStatistics() {
        // Calcula estatísticas usando todas as transações armazenadas
        DoubleSummaryStatistics stats = transactions.stream()
                .mapToDouble(Transaction::getValor)
                .summaryStatistics();
    
        // Retorna o DTO com os valores calculados
        return new statisticsDTO(
                stats.getCount(),
                stats.getSum(),
                stats.getCount() > 0 ? stats.getAverage() : 0.0,
                stats.getCount() > 0 ? stats.getMin() : 0.0,
                stats.getCount() > 0 ? stats.getMax() : 0.0
        );
    }
}