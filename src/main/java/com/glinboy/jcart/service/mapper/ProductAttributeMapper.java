package com.glinboy.jcart.service.mapper;

import org.mapstruct.Mapper;

import com.glinboy.jcart.model.ProductAttribute;
import com.glinboy.jcart.service.dto.ProductAttributeDTO;

@Mapper(componentModel = "spring", uses = {})
public interface ProductAttributeMapper extends EntityMapper<ProductAttributeDTO, ProductAttribute> {

}
