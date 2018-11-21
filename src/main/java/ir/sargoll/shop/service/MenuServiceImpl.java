package ir.sargoll.shop.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import ir.sargoll.shop.model.Menu;
import ir.sargoll.shop.repository.MenuRepositoryApi;

@Service
@Transactional
public class MenuServiceImpl extends AbstractServiceImpl<Menu, MenuRepositoryApi> implements MenuServiceApi {
}
