package com.glinboy.jcart.service.dto;

import lombok.Data;

@Data 
public abstract class BaseDTO {
	private Long id;
	private Boolean isActive;
}
