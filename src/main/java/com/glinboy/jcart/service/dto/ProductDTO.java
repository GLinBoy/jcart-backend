package com.glinboy.jcart.service.dto;

import java.util.List;
import java.util.Set;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public abstract class ProductDTO extends BaseDTO {
	private String name;
	private String description;
	private List<ProductAttributeDTO> attributes;
	private Double price;
	private Double rate;
	private String code;
	private List<ProductCategoryDTO> categories;
	private List<ImageDTO> images;
	private Set<DiscountDTO> discounts;
}
