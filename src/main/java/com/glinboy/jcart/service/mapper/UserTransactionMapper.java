package com.glinboy.jcart.service.mapper;

import org.mapstruct.Mapper;

import com.glinboy.jcart.model.UserTransaction;
import com.glinboy.jcart.service.dto.UserTransactionDTO;

@Mapper(componentModel = "spring", uses = {})
public interface UserTransactionMapper extends EntityMapper<UserTransactionDTO, UserTransaction> {

}
