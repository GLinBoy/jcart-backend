package com.glinboy.jcart.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.glinboy.jcart.model.Image;
import com.glinboy.jcart.repository.ImageRepositoryApi;

@Service
@Transactional
public class ImageServiceImpl extends AbstractServiceImpl<Image, ImageRepositoryApi> implements ImageServiceApi {
}
