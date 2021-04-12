package com.glinboy.jcart.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.glinboy.jcart.model.Menu;
import com.glinboy.jcart.repository.MenuRepositoryApi;
import com.glinboy.jcart.service.MenuServiceApi;

@Service
@Transactional
public class MenuServiceImpl extends AbstractServiceImpl<Menu, MenuRepositoryApi> implements MenuServiceApi {

	public MenuServiceImpl(MenuRepositoryApi repository) {
		super(repository);
	}

}
