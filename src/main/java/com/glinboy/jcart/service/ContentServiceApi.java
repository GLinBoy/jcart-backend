package com.glinboy.jcart.service;

import com.glinboy.jcart.service.dto.ContentDTO;

public interface ContentServiceApi extends GenericService<ContentDTO> {
	ContentDTO getSingleByTitle(String title);
}
