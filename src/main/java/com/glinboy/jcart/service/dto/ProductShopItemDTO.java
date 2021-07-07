package com.glinboy.jcart.service.dto;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class ProductShopItemDTO extends ProductDTO {
	private List<ProductCommentDTO> comments;
}
