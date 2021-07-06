package com.glinboy.jcart.service.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class DiscountDTO extends BaseDTO {
	private Long userId;
	private Long productId;
	private Double percent;
	private Double ceiling;
}
