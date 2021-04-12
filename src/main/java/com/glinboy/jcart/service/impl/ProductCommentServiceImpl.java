package com.glinboy.jcart.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.glinboy.jcart.model.ProductComment;
import com.glinboy.jcart.repository.ProductCommentRepositoryApi;
import com.glinboy.jcart.service.ProductCommentServiceApi;

@Service
@Transactional
public class ProductCommentServiceImpl extends AbstractServiceImpl<ProductComment, ProductCommentRepositoryApi> implements ProductCommentServiceApi {

	public ProductCommentServiceImpl(ProductCommentRepositoryApi repository) {
		super(repository);
	}

}
