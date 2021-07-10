package com.glinboy.jcart.service;

import com.glinboy.jcart.service.dto.DiscountDTO;

public interface DiscountServiceApi extends GenericService<DiscountDTO> {
	Boolean verify(Long id);
}
