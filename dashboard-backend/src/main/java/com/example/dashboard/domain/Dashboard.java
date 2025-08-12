package com.example.dashboard.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Dashboard extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @Column(length = 8000)
    private String layoutJson;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLayoutJson() {
        return layoutJson;
    }

    public void setLayoutJson(String layoutJson) {
        this.layoutJson = layoutJson;
    }
}