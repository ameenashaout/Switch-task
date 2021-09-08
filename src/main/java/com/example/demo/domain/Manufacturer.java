package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "manufacturer")
public class Manufacturer extends AbstractAuditingEntity {
private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
