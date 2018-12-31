package com.glinboy.jcart.service;

import com.glinboy.jcart.model.Content;

public interface ContentServiceApi  extends GenericService<Content> {
    Content getSingleByTitle(String title);
}
