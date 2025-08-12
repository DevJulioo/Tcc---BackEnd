package com.example.dashboard.web.mapper;

import com.example.dashboard.domain.Dashboard;
import com.example.dashboard.web.dto.DashboardDto;

public class DashboardMapper {
    public static DashboardDto toDto(Dashboard entity) {
        DashboardDto dto = new DashboardDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setLayoutJson(entity.getLayoutJson());
        return dto;
    }

    public static Dashboard toEntity(DashboardDto dto) {
        Dashboard entity = new Dashboard();
        entity.setName(dto.getName());
        entity.setLayoutJson(dto.getLayoutJson());
        return entity;
    }
}