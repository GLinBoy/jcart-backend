package ir.sargoll.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ir.sargoll.shop.model.Setting;

public interface SettingRepositoryApi extends JpaRepository<Setting, Long> {
}
