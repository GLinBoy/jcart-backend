package com.glinboy.jcart.service.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ImageDTO extends BaseDTO {
	private String name;
	private String path;
	private Integer ordering;
}
