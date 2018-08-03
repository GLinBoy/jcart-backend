package ir.sargoll.shop.repository;

import ir.sargoll.shop.model.Setting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettingRepositoryApi extends JpaRepository<Setting, Long> {
}
