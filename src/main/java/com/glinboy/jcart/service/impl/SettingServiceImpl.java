package com.glinboy.jcart.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.glinboy.jcart.model.Setting;
import com.glinboy.jcart.repository.SettingRepositoryApi;
import com.glinboy.jcart.service.SettingServiceApi;

@Service
@Transactional
public class SettingServiceImpl extends AbstractServiceImpl<Setting, SettingRepositoryApi> implements SettingServiceApi {

	public SettingServiceImpl(SettingRepositoryApi repository) {
		super(repository);
	}

}
