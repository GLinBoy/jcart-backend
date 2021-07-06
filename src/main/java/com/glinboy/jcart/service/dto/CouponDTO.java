package com.glinboy.jcart.service.dto;

import java.time.LocalDate;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CouponDTO extends BaseDTO {
	private Double percent;
	private Double ceiling;
	private String code;
	private LocalDate start;
	private LocalDate end;
}
