package com.glinboy.jcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glinboy.jcart.model.Setting;

public interface SettingRepositoryApi extends JpaRepository<Setting, Long> {
}
