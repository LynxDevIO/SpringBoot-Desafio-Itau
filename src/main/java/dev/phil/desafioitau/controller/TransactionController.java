package dev.phil.desafioitau.controller;

import dev.phil.desafioitau.dto.TransactionDto;
import dev.phil.desafioitau.model.Transaction;
import dev.phil.desafioitau.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/transacao")
public class TransactionController {
    private final TransactionService transactionService;
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Void> createTransaction(@Valid @RequestBody TransactionDto transactionDto) {
        if (transactionDto.getDataHora().isAfter(OffsetDateTime.now())
                || transactionDto.getValor() <= 0) {
            return ResponseEntity.unprocessableEntity().build();
        }
        transactionService.addTransaction(new Transaction(transactionDto.getValor(), transactionDto.getDataHora()));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteTransaction(@Valid @RequestBody TransactionDto transactionDto) {
        transactionService.clearTransactions();
        return ResponseEntity.ok().build();
    }
}
