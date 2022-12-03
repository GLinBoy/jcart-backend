package com.glinboy.jcart.service.impl;

import org.springframework.stereotype.Service;

import com.glinboy.jcart.model.ProductComment;
import com.glinboy.jcart.repository.ProductCommentRepositoryApi;
import com.glinboy.jcart.service.ProductCommentServiceApi;
import com.glinboy.jcart.service.dto.ProductCommentDTO;
import com.glinboy.jcart.service.mapper.ProductCommentMapper;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductCommentServiceImpl
		extends AbstractServiceImpl<ProductCommentDTO, ProductComment, ProductCommentMapper, ProductCommentRepositoryApi>
		implements ProductCommentServiceApi {

	public ProductCommentServiceImpl(ProductCommentRepositoryApi repository, ProductCommentMapper mapper) {
		super(repository, mapper);
	}

}
