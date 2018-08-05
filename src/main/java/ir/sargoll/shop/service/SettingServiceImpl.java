package ir.sargoll.shop.service;

import ir.sargoll.shop.model.Setting;
import ir.sargoll.shop.repository.SettingRepositoryApi;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SettingServiceImpl extends AbstractServiceImpl<Setting, SettingRepositoryApi> implements SettingServiceApi {
}
