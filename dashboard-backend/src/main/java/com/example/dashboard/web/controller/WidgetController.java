package com.example.dashboard.web.controller;

import com.example.dashboard.domain.Widget;
import com.example.dashboard.service.DashboardService;
import com.example.dashboard.web.dto.WidgetDto;
import com.example.dashboard.web.mapper.WidgetMapper;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/widgets")
public class WidgetController {

    private final DashboardService dashboardService;

    public WidgetController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping
    public List<WidgetDto> listWidgets() {
        return dashboardService
                .listWidgets()
                .stream()
                .map(WidgetMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<WidgetDto> createWidget(@Valid @RequestBody WidgetDto dto) {
        Widget created = dashboardService.createWidget(WidgetMapper.toEntity(dto));
        WidgetDto response = WidgetMapper.toDto(created);
        return ResponseEntity.created(URI.create("/api/widgets/" + created.getId())).body(response);
    }
}