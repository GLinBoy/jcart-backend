package com.glinboy.jcart.service.mapper;

import org.mapstruct.Mapper;

import com.glinboy.jcart.model.ProductOrderItem;
import com.glinboy.jcart.service.dto.ProductOrderItemDTO;

@Mapper(componentModel = "spring", uses = {})
public interface ProductOrderItemMapper extends EntityMapper<ProductOrderItemDTO, ProductOrderItem> {

}
