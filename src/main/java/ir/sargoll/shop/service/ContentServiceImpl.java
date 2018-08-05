package ir.sargoll.shop.service;

import ir.sargoll.shop.model.Content;
import ir.sargoll.shop.repository.ContentRepositoryApi;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ContentServiceImpl extends AbstractServiceImpl<Content, ContentRepositoryApi> implements ContentServiceApi {
}
