package com.glinboy.jcart.service.mapper;

import org.mapstruct.Mapper;

import com.glinboy.jcart.model.Setting;
import com.glinboy.jcart.service.dto.SettingDTO;

@Mapper(componentModel = "spring", uses = {})
public interface SettingMapper extends EntityMapper<SettingDTO, Setting> {

}
