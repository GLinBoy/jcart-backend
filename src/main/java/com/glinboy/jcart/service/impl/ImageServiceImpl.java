package com.glinboy.jcart.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.glinboy.jcart.model.Image;
import com.glinboy.jcart.repository.ImageRepositoryApi;
import com.glinboy.jcart.service.ImageServiceApi;

@Service
@Transactional
public class ImageServiceImpl extends AbstractServiceImpl<Image, ImageRepositoryApi> implements ImageServiceApi {

	public ImageServiceImpl(ImageRepositoryApi repository) {
		super(repository);
	}

}
