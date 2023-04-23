package com.carbonesoftware.portfolio.controller;

import com.carbonesoftware.portfolio.entity.Configuration;
import com.carbonesoftware.portfolio.services.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/config")
@RestController
@CrossOrigin("*")
public class ConfigurationController {

    @Autowired
    private ConfigurationService configSvc;

    @PostMapping("/")
    public ResponseEntity<?> saveConfiguration(@RequestBody Configuration data){
        return ResponseEntity.ok(configSvc.save(data));
    }
    @GetMapping("/")
    public ResponseEntity<?> getAllConfiguration(){
        return ResponseEntity.ok(configSvc.getAll());
    }
    @GetMapping("/{name}")
    public ResponseEntity<?> getConfiguration(@PathVariable("name") String name){
        return ResponseEntity.ok(configSvc.get(name));
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<?> deleteConfiguration(@PathVariable("name") String name){
        configSvc.remove(name);
        return ResponseEntity.ok(null);
    }
}
