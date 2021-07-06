package com.glinboy.jcart.service.dto;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProductCategoryDTO extends BaseDTO {
	private String name;
	private String description;
	private Long parentId;
	private Long imageId;
	private List<ProductCategoryDTO> childes;
}
