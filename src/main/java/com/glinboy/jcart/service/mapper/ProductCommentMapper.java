package com.glinboy.jcart.service.mapper;

import org.mapstruct.Mapper;

import com.glinboy.jcart.model.ProductComment;
import com.glinboy.jcart.service.dto.ProductCommentDTO;

@Mapper(componentModel = "spring", uses = {})
public interface ProductCommentMapper extends EntityMapper<ProductCommentDTO, ProductComment> {

}
