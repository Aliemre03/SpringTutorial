package com.example.springtutorial.dto.converter;

import com.example.springtutorial.dto.TransactionDto;
import com.example.springtutorial.model.Transaction;

public class TransactionDtoConverter {
    public TransactionDto convert(Transaction from) {
        return new TransactionDto(from.getId(),
                from.getTransactionType(),
                from.getAmount(),
                from.getTransactionDate());
    }
}
