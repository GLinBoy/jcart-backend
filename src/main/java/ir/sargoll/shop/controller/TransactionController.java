package ir.sargoll.shop.controller;

import ir.sargoll.shop.model.UserTransaction;
import ir.sargoll.shop.service.UserTransactionServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/transactions")
public class TransactionController {

    @Autowired
    private UserTransactionServiceApi transactionService;

    @GetMapping
    public Page<UserTransaction> getAll(Pageable pageable) {
        return transactionService.getAll(pageable);
    }

    @GetMapping(path = "/{id}")
    public UserTransaction get(@PathVariable Long id){
        return transactionService.getSingleById(id);
    }

}