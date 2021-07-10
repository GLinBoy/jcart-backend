package com.glinboy.jcart.service;

import com.glinboy.jcart.model.Content;
import com.glinboy.jcart.service.dto.ContentDTO;

public interface ContentServiceApi extends GenericService<ContentDTO> {
	Content getSingleByTitle(String title);
}
