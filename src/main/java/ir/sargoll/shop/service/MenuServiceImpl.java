package ir.sargoll.shop.service;

import ir.sargoll.shop.model.Menu;
import ir.sargoll.shop.repository.MenuRepositoryApi;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class MenuServiceImpl extends AbstractServiceImpl<Menu, MenuRepositoryApi> implements MenuServiceApi {
}
