package com.glinboy.jcart.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.glinboy.jcart.model.Image;
import com.glinboy.jcart.repository.ImageRepositoryApi;
import com.glinboy.jcart.service.ImageServiceApi;
import com.glinboy.jcart.service.dto.ImageDTO;
import com.glinboy.jcart.service.mapper.ImageMapper;

@Service
@Transactional
public class ImageServiceImpl extends AbstractServiceImpl<ImageDTO, Image, ImageMapper, ImageRepositoryApi>
		implements ImageServiceApi {

	public ImageServiceImpl(ImageRepositoryApi repository, ImageMapper mapper) {
		super(repository, mapper);
	}

}
