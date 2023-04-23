package com.carbonesoftware.portfolio.services.impl;

import com.carbonesoftware.portfolio.entity.Configuration;
import com.carbonesoftware.portfolio.repository.ConfigurationRepository;
import com.carbonesoftware.portfolio.services.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConfigurationServiceImpl implements ConfigurationService {

    @Autowired
    private ConfigurationRepository configRepo;

    @Override
    public Configuration save(Configuration data) {
        return configRepo.save(data);
    }

    @Override
    public List<Configuration> getAll() {
        return configRepo.findAll();
    }

    @Override
    public Optional<Configuration> get(String name) {
        return configRepo.findById(name);
    }

    @Override
    public void remove(String name) {
        configRepo.deleteById(name);
    }
}
