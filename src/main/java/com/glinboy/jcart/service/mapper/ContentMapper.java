package com.glinboy.jcart.service.mapper;

import org.mapstruct.Mapper;

import com.glinboy.jcart.model.Content;
import com.glinboy.jcart.service.dto.ContentDTO;

@Mapper(componentModel = "spring", uses = {})
public interface ContentMapper extends EntityMapper<ContentDTO, Content>{

}
