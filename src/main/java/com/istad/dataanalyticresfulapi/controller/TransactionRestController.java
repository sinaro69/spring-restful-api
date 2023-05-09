package com.istad.dataanalyticresfulapi.controller;

import com.github.pagehelper.PageInfo;
import com.istad.dataanalyticresfulapi.model.Transaction;
import com.istad.dataanalyticresfulapi.service.TransactionService;
import com.istad.dataanalyticresfulapi.utils.Response;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionRestController {
    TransactionService transactionService;
    TransactionRestController(TransactionService transactionService){
        this.transactionService=transactionService;
    }

    //getAllTransaction
    @GetMapping("/all-transactions")
    public Response<PageInfo<Transaction>> getAllTransaction(@RequestParam(defaultValue = "1") int page,
                                                             @RequestParam(defaultValue = "5") int size){
        try {
            PageInfo<Transaction> transactions = transactionService.getAllTransactions(page, size);
            return Response.<PageInfo<Transaction>>ok().setPayload(transactions).setMessage("You got the data Successfully!");
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
            return Response.<PageInfo<Transaction>>exception().setMessage("Error happened! data not found!");
        }
    }
    @PostMapping("/create-new-transaction")
    public Response<Transaction> createTransaction(@RequestBody Transaction transaction) {
        int created = transactionService.createTransaction(transaction);
        if (created > 0) {
            return Response.<Transaction>ok().setPayload(transaction)
                    .setSuccess(true)
                    .setMessage("successfully! added");
        } else {
            return Response.<Transaction>notFound().setPayload(null)
                    .setSuccess(false)
                    .setMessage("Try again! Transaction not found!");
        }
    }
    @DeleteMapping("remove-transaction/{id}")
    public Response<Void> deleteTransaction(@PathVariable int id) {
        try{
            int deleted = transactionService.deleteTransaction(id);
            if (deleted > 0) {
                return Response.<Void>ok().setMessage("Successfully deleted").setSuccess(true);
            } else {
                return Response.<Void>notFound().setMessage("Transaction not found! none data to delete!");
            }
        }catch (Exception e){
            return Response.<Void>exception().setSuccess(true).setMessage("Data not found!");
        }
    }

}
