package com.glinboy.jcart.service.dto;

import com.glinboy.jcart.model.MenuTarget;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class MenuDTO extends BaseDTO {
	private String name;
	private String description;
	private String href;
	private MenuTarget target;
}
