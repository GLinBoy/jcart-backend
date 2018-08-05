package ir.sargoll.shop.service;

import ir.sargoll.shop.model.ProductComment;
import ir.sargoll.shop.repository.ProductCommentRepositoryApi;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProductCommentServiceImpl extends AbstractServiceImpl<ProductComment, ProductCommentRepositoryApi> implements ProductCommentServiceApi {
}
