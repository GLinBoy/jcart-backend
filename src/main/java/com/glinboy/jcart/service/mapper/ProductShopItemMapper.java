package com.glinboy.jcart.service.mapper;

import org.mapstruct.Mapper;

import com.glinboy.jcart.model.ProductShopItem;
import com.glinboy.jcart.service.dto.ProductShopItemDTO;

@Mapper(componentModel = "spring", uses = {})
public interface ProductShopItemMapper extends EntityMapper<ProductShopItemDTO, ProductShopItem> {

}
