package com.example.dashboard.web.mapper;

import com.example.dashboard.domain.Widget;
import com.example.dashboard.web.dto.WidgetDto;

public class WidgetMapper {
    public static WidgetDto toDto(Widget entity) {
        WidgetDto dto = new WidgetDto();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setType(entity.getType());
        dto.setConfigJson(entity.getConfigJson());
        return dto;
    }

    public static Widget toEntity(WidgetDto dto) {
        Widget entity = new Widget();
        entity.setTitle(dto.getTitle());
        entity.setType(dto.getType());
        entity.setConfigJson(dto.getConfigJson());
        return entity;
    }
}