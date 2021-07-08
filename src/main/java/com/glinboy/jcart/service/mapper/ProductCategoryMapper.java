package com.glinboy.jcart.service.mapper;

import org.mapstruct.Mapper;

import com.glinboy.jcart.model.ProductCategory;
import com.glinboy.jcart.service.dto.ProductCategoryDTO;

@Mapper(componentModel = "spring", uses = {})
public interface ProductCategoryMapper extends EntityMapper<ProductCategoryDTO, ProductCategory> {

}
