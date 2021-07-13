package com.glinboy.jcart.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.glinboy.jcart.model.Menu;
import com.glinboy.jcart.repository.MenuRepositoryApi;
import com.glinboy.jcart.service.MenuServiceApi;
import com.glinboy.jcart.service.dto.MenuDTO;
import com.glinboy.jcart.service.mapper.MenuMapper;

@Service
@Transactional
public class MenuServiceImpl extends AbstractServiceImpl<MenuDTO, Menu, MenuMapper, MenuRepositoryApi>
		implements MenuServiceApi {

	public MenuServiceImpl(MenuRepositoryApi repository, MenuMapper mapper) {
		super(repository, mapper);
	}

}
