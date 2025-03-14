package dev.phil.desafioitau.dto;

import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;

public class TransactionDto {
    @NotNull
    private double valor;
    @NotNull
    private OffsetDateTime dataHora;

    public TransactionDto(double valor, OffsetDateTime dataHora) {
        this.valor = valor;
        this.dataHora = dataHora;
    }

    public double getValor() {
        return valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }
}
