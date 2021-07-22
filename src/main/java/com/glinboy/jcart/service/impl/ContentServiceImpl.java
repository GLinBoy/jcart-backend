package com.glinboy.jcart.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.glinboy.jcart.model.Content;
import com.glinboy.jcart.model.ResourceNotFoundException;
import com.glinboy.jcart.repository.ContentRepositoryApi;
import com.glinboy.jcart.service.ContentServiceApi;
import com.glinboy.jcart.service.dto.ContentDTO;
import com.glinboy.jcart.service.mapper.ContentMapper;

@Service
@Transactional
public class ContentServiceImpl extends AbstractServiceImpl<ContentDTO, Content, ContentMapper, ContentRepositoryApi>
		implements ContentServiceApi {

	public ContentServiceImpl(ContentRepositoryApi repository, ContentMapper mapper) {
		super(repository, mapper);
	}

	@Override
	public ContentDTO getSingleByTitle(String title) {
		Content c = repository.findByTitle(title).orElseThrow(
				() -> new ResourceNotFoundException(String.format("Content by title %s doesn't exist!", title)));
		return mapper.toDto(c);
	}
}
