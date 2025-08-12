package com.example.dashboard.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Widget extends BaseEntity {

    public enum WidgetType {
        KPI,
        CHART_LINE,
        CHART_BAR,
        TABLE
    }

    @Column(nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WidgetType type;

    @Column(length = 4000)
    private String configJson;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public WidgetType getType() {
        return type;
    }

    public void setType(WidgetType type) {
        this.type = type;
    }

    public String getConfigJson() {
        return configJson;
    }

    public void setConfigJson(String configJson) {
        this.configJson = configJson;
    }
}