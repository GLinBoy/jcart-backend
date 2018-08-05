package ir.sargoll.shop.service;

import ir.sargoll.shop.model.Image;
import ir.sargoll.shop.repository.ImageRepositoryApi;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ImageServiceImpl extends AbstractServiceImpl<Image, ImageRepositoryApi> implements ImageServiceApi {
}
