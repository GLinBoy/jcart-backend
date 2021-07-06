package com.glinboy.jcart.service.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ContentDTO extends BaseDTO {
	private String title;
	private String content;
}
