package com.carbonesoftware.portfolio.repository;

import com.carbonesoftware.portfolio.entity.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigurationRepository extends JpaRepository<Configuration, String> {

}
