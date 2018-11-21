package ir.sargoll.shop.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import ir.sargoll.shop.model.Setting;
import ir.sargoll.shop.repository.SettingRepositoryApi;

@Service
@Transactional
public class SettingServiceImpl extends AbstractServiceImpl<Setting, SettingRepositoryApi> implements SettingServiceApi {
}
