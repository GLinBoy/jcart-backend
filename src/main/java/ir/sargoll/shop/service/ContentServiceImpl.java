package ir.sargoll.shop.service;

import ir.sargoll.shop.model.Content;
import ir.sargoll.shop.model.ResourceNotFoundException;
import ir.sargoll.shop.repository.ContentRepositoryApi;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
