package com.glinboy.jcart.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.glinboy.jcart.model.Menu;
import com.glinboy.jcart.repository.MenuRepositoryApi;

@Service
@Transactional
public class MenuServiceImpl extends AbstractServiceImpl<Menu, MenuRepositoryApi> implements MenuServiceApi {
}
