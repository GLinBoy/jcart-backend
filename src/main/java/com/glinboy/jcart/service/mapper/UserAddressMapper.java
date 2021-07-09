package com.glinboy.jcart.service.mapper;

import org.mapstruct.Mapper;

import com.glinboy.jcart.model.UserAddress;
import com.glinboy.jcart.service.dto.UserAddressDTO;

@Mapper(componentModel = "spring", uses = {})
public interface UserAddressMapper extends EntityMapper<UserAddressDTO, UserAddress> {

}
