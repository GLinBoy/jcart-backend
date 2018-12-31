package com.glinboy.jcart.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.glinboy.jcart.model.ProductComment;
import com.glinboy.jcart.repository.ProductCommentRepositoryApi;

@Service
@Transactional
public class ProductCommentServiceImpl extends AbstractServiceImpl<ProductComment, ProductCommentRepositoryApi> implements ProductCommentServiceApi {
}
