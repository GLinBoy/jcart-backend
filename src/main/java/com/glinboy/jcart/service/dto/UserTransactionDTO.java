package com.glinboy.jcart.service.dto;

import java.time.LocalDate;

import com.glinboy.jcart.model.TransactionStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserTransactionDTO extends BaseDTO {
    private LocalDate date;
    private Double price;
    private TransactionStatus status;
    private Long orderId;
    private Long userId;
}
