package com.glinboy.jcart.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.glinboy.jcart.model.UserGroup;
import com.glinboy.jcart.repository.UserGroupRepositoryApi;
import com.glinboy.jcart.service.UserGroupServiceApi;
import com.glinboy.jcart.service.dto.UserGroupDTO;
import com.glinboy.jcart.service.mapper.UserGroupMapper;

@Service
@Transactional
public class UserGroupServiceImpl
		extends AbstractServiceImpl<UserGroupDTO, UserGroup, UserGroupMapper, UserGroupRepositoryApi>
		implements UserGroupServiceApi {

	public UserGroupServiceImpl(UserGroupRepositoryApi repository, UserGroupMapper mapper) {
		super(repository, mapper);
	}
}
