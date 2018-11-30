package ir.sargoll.shop.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import ir.sargoll.shop.model.Content;
import ir.sargoll.shop.model.ResourceNotFoundException;
import ir.sargoll.shop.repository.ContentRepositoryApi;

@Service
@Transactional
public class ContentServiceImpl extends AbstractServiceImpl<Content, ContentRepositoryApi> implements ContentServiceApi {
    @Override
    public Content getSingleByTitle(String title) {
        return repository.findByTitle(title).orElseThrow(()->
                new ResourceNotFoundException(
                        String.format("Content by title %s doesn't exist!", title)
        ));
    }
}
