package ir.sargoll.shop.service;

import ir.sargoll.shop.model.UserGroup;
import ir.sargoll.shop.repository.UserGroupRepositoryApi;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserGroupServiceImpl
        extends AbstractServiceImpl<UserGroup, UserGroupRepositoryApi>
        implements UserGroupServiceApi {
}
