package com.glinboy.jcart.service.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class ProductCommentDTO extends BaseDTO {
	private Long userId;
	private String comment;
	private Integer rate;
	private ProductShopItemDTO product;
}
