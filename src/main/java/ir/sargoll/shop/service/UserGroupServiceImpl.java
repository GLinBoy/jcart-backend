package ir.sargoll.shop.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import ir.sargoll.shop.model.UserGroup;
import ir.sargoll.shop.repository.UserGroupRepositoryApi;

@Service
@Transactional
public class UserGroupServiceImpl
        extends AbstractServiceImpl<UserGroup, UserGroupRepositoryApi>
        implements UserGroupServiceApi {
}
