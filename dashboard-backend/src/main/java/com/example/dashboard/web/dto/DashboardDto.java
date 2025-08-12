package com.example.dashboard.web.dto;

import jakarta.validation.constraints.NotBlank;

public class DashboardDto {
    private Long id;

    @NotBlank
    private String name;

    private String layoutJson;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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