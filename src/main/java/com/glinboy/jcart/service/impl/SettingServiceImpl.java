package com.glinboy.jcart.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.glinboy.jcart.model.Setting;
import com.glinboy.jcart.repository.SettingRepositoryApi;
import com.glinboy.jcart.service.SettingServiceApi;
import com.glinboy.jcart.service.dto.SettingDTO;
import com.glinboy.jcart.service.mapper.SettingMapper;

@Service
@Transactional
public class SettingServiceImpl extends AbstractServiceImpl<SettingDTO, Setting, SettingMapper, SettingRepositoryApi>
		implements SettingServiceApi {

	public SettingServiceImpl(SettingRepositoryApi repository, SettingMapper mapper) {
		super(repository, mapper);
	}
}
