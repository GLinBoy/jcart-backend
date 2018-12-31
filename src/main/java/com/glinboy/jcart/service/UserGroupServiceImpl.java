package com.glinboy.jcart.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.glinboy.jcart.model.UserGroup;
import com.glinboy.jcart.repository.UserGroupRepositoryApi;

@Service
@Transactional
public class UserGroupServiceImpl
        extends AbstractServiceImpl<UserGroup, UserGroupRepositoryApi>
        implements UserGroupServiceApi {
}
