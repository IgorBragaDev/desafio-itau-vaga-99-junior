package com.example.DesafioItau.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.OffsetDateTime;

public class TransactionDTO {

    @NotNull(message = "O campo 'valor' é obrigatório.")
    @PositiveOrZero(message = "O valor da transação deve ser igual ou maior que zero.")
    private Double valor;

    @NotNull(message = "O campo 'dataHora' é obrigatório.")
    @PastOrPresent(message = "A data/hora da transação não pode estar no futuro.")
    private OffsetDateTime dataHora;

    // Getters e Setters
    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(OffsetDateTime dataHora) {
        this.dataHora = dataHora;
    }
}