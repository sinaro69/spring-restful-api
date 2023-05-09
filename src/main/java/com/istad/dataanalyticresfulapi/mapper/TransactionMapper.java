package com.istad.dataanalyticresfulapi.mapper;

import com.istad.dataanalyticresfulapi.model.Transaction;
import com.istad.dataanalyticresfulapi.model.response.TransactionResponse;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface TransactionMapper {

    List<Transaction> mapToTransaction(List<TransactionResponse> response);
    List<TransactionResponse> mapToTransactionResponse(List<Transaction> transaction);
}
