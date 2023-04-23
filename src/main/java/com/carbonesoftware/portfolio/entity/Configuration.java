package com.carbonesoftware.portfolio.entity;


import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "configurations")
public class Configuration {
    @Id
    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "value", length = 2000)
    private String value;
}
