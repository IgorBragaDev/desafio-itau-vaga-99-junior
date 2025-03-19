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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class TransactionService {
    private final List<Transaction> transactions = new ArrayList<>();
    private static final Logger logger = LoggerFactory.getLogger(TransactionService.class);

    public Transaction createTransaction(Transaction transaction) {
        transactions.add(transaction);
        return transaction; 

    }

    public List<Transaction> getAllTransactions() {
        return Collections.unmodifiableList(transactions);
    }

    public statisticsDTO getStatistics() {
        OffsetDateTime now = OffsetDateTime.now();
        OffsetDateTime oneMinuteAgo = now.minusSeconds(60);

        logger.info("Calculando estatísticas para transações entre {} e {}", oneMinuteAgo, now);

        // Filtra transações dos últimos 60 segundos
        List<Transaction> recentTransactions = transactions.stream()
                .filter(t -> {
                    boolean isInInterval = !t.getDataHora().isBefore(oneMinuteAgo) && !t.getDataHora().isAfter(now);
                    logger.info("Transação: {}, Dentro do intervalo: {}", t, isInInterval);
                    return isInInterval;
                })
                .collect(Collectors.toList());

        // Calcula estatísticas usando DoubleSummaryStatistics
        DoubleSummaryStatistics stats = recentTransactions.stream()
                .mapToDouble(Transaction::getValor)
                .summaryStatistics();

        logger.info("Estatísticas calculadas: count={}, sum={}, avg={}, min={}, max={}",
                stats.getCount(), stats.getSum(), stats.getAverage(), stats.getMin(), stats.getMax());

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