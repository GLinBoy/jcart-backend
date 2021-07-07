package com.glinboy.jcart.service.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.glinboy.jcart.model.OrderStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class OrderDTO extends BaseDTO {
	private Long userId;
    private OrderStatus status;
    private Set<CouponDTO> coupons;
    private List<ProductOrderItemDTO> items;
    private LocalDate orderDate;
    private UserAddressDTO deliveryAddress;
    private UserAddressDTO factorAddress;
    private LocalDate deliveryDate;
    private String description;
}
