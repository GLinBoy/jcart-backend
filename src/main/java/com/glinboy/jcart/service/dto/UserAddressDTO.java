package com.glinboy.jcart.service.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserAddressDTO extends BaseDTO {
	private Long userId;
	private String deliveryName;
	private String address;
	private String country;
	private String state;
	private String city;
	private String zipCode;
	private String phone;
	private String longitude;
	private String latitude;
}
