package com.glinboy.jcart.service.dto;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ContactDTO extends BaseDTO {
	String email;
	UserAddressDTO address;
	List<UserAddressDTO> agencies;
}
