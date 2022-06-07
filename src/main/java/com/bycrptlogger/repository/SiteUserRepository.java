package com.bycrptlogger.repository;

import com.bycrptlogger.model.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteUserRepository extends JpaRepository< SiteUser, Long> {
    SiteUser findByUsername(String username);
}
