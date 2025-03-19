package com.example.DesafioItau.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;


public class TransactionDTO {

    @NotNull(message = "O campo 'valor' é obrigatório.")
    @PositiveOrZero(message = "O valor da transação deve ser igual ou maior que zero.")
    private Double valor;

  

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    
}