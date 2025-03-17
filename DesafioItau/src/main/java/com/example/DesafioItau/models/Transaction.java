package com.example.DesafioItau.models;

import java.time.OffsetDateTime;

public class Transaction {
    private double valor;
    private OffsetDateTime dataHora;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(OffsetDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
