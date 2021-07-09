package com.glinboy.jcart.service.mapper;

import org.mapstruct.Mapper;

import com.glinboy.jcart.model.UserGroup;
import com.glinboy.jcart.service.dto.UserGroupDTO;

@Mapper(componentModel = "spring", uses = {})
public interface UserGroupMapper extends EntityMapper<UserGroupDTO, UserGroup> {

}
