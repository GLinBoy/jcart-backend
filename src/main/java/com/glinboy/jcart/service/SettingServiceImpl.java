package com.glinboy.jcart.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.glinboy.jcart.model.Setting;
import com.glinboy.jcart.repository.SettingRepositoryApi;

@Service
@Transactional
public class SettingServiceImpl extends AbstractServiceImpl<Setting, SettingRepositoryApi> implements SettingServiceApi {
}
