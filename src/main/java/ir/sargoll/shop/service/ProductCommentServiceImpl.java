package ir.sargoll.shop.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import ir.sargoll.shop.model.ProductComment;
import ir.sargoll.shop.repository.ProductCommentRepositoryApi;

@Service
@Transactional
public class ProductCommentServiceImpl extends AbstractServiceImpl<ProductComment, ProductCommentRepositoryApi> implements ProductCommentServiceApi {
}
