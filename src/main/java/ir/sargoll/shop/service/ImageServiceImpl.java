package ir.sargoll.shop.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import ir.sargoll.shop.model.Image;
import ir.sargoll.shop.repository.ImageRepositoryApi;

@Service
@Transactional
public class ImageServiceImpl extends AbstractServiceImpl<Image, ImageRepositoryApi> implements ImageServiceApi {
}
