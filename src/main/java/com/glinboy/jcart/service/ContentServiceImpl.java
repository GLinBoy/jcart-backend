package com.glinboy.jcart.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.glinboy.jcart.model.Content;
import com.glinboy.jcart.model.ResourceNotFoundException;
import com.glinboy.jcart.repository.ContentRepositoryApi;

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
