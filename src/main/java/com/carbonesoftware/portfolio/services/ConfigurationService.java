package com.carbonesoftware.portfolio.services;

import com.carbonesoftware.portfolio.entity.Configuration;

import java.util.List;
import java.util.Optional;

public interface ConfigurationService {
    Configuration save(Configuration data);
    List<Configuration> getAll();
    Optional<Configuration> get(String name);
    void remove(String name);

}
