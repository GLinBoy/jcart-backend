package com.glinboy.jcart.service.mapper;

import org.mapstruct.Mapper;

import com.glinboy.jcart.model.Menu;
import com.glinboy.jcart.service.dto.MenuDTO;

@Mapper(componentModel = "spring", uses = {})
public interface MenuMapper extends EntityMapper<MenuDTO, Menu> {

}
