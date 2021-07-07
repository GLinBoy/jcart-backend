package com.glinboy.jcart.service.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class ProductOrderItemDTO extends ProductDTO {
	private OrderDTO order;
	private Integer number;
}
