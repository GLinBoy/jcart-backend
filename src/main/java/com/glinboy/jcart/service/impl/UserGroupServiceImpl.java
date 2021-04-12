package com.glinboy.jcart.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.glinboy.jcart.model.UserGroup;
import com.glinboy.jcart.repository.UserGroupRepositoryApi;
import com.glinboy.jcart.service.UserGroupServiceApi;

@Service
@Transactional
public class UserGroupServiceImpl extends AbstractServiceImpl<UserGroup, UserGroupRepositoryApi>
		implements UserGroupServiceApi {

	public UserGroupServiceImpl(UserGroupRepositoryApi repository) {
		super(repository);
	}
}
