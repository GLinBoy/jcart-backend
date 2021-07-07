package com.glinboy.jcart.service.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.glinboy.jcart.model.Setting;
import com.glinboy.jcart.model.UserGender;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class UserDTO extends BaseDTO {
	private String name;
	private String family;
	private String email;
	private String mobile;
	private String password;
	private Boolean isDeleted = Boolean.FALSE;
	private List<UserAddressDTO> addresses;
	private Double level;
	private List<UserGroupDTO> groups;
	private List<DiscountDTO> discounts;
	private List<OrderDTO> orders;
	private Setting setting;
	private UserGender gender;
	private Boolean verifiedEmail;
	private Boolean verifiedMobile;
	private String codeIntroducing;
	private String codeReagent;
	private Long wallet;

	@JsonProperty
	public String getFullName() {
		return this.name + " " + this.family;
	}
}
