package com.example.dashboard.web.controller;

import com.example.dashboard.domain.Dashboard;
import com.example.dashboard.domain.DashboardWidget;
import com.example.dashboard.domain.Widget;
import com.example.dashboard.service.DashboardService;
import com.example.dashboard.web.dto.DashboardDto;
import com.example.dashboard.web.dto.DashboardWidgetDto;
import com.example.dashboard.web.dto.WidgetDto;
import com.example.dashboard.web.mapper.DashboardMapper;
import com.example.dashboard.web.mapper.WidgetMapper;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboards")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping
    public List<DashboardDto> listDashboards() {
        return dashboardService.listDashboards().stream()
                .map(DashboardMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<DashboardDto> createDashboard(@Valid @RequestBody DashboardDto dto) {
        Dashboard created = dashboardService.createDashboard(DashboardMapper.toEntity(dto));
        DashboardDto response = DashboardMapper.toDto(created);
        return ResponseEntity.created(URI.create("/api/dashboards/" + created.getId())).body(response);
    }

    @GetMapping("/{id}")
    public DashboardDto getDashboard(@PathVariable Long id) {
        return DashboardMapper.toDto(dashboardService.getDashboard(id));
    }

    @PostMapping("/{id}/widgets")
    public ResponseEntity<DashboardWidgetDto> addWidget(@PathVariable Long id, @Valid @RequestBody DashboardWidgetDto dto) {
        DashboardWidget placement = dashboardService.addWidgetToDashboard(
                id, dto.getWidgetId(), dto.getPositionX(), dto.getPositionY(), dto.getWidth(), dto.getHeight());
        DashboardWidgetDto response = new DashboardWidgetDto();
        response.setId(placement.getId());
        response.setDashboardId(id);
        response.setWidgetId(placement.getWidget().getId());
        response.setPositionX(placement.getPositionX());
        response.setPositionY(placement.getPositionY());
        response.setWidth(placement.getWidth());
        response.setHeight(placement.getHeight());
        return ResponseEntity.created(URI.create("/api/dashboards/" + id + "/widgets/" + placement.getId())).body(response);
    }

    @GetMapping("/{id}/widgets")
    public List<WidgetDto> listWidgets(@PathVariable Long id) {
        return dashboardService.listWidgetsForDashboard(id).stream()
                .map(DashboardWidget::getWidget)
                .map(WidgetMapper::toDto)
                .collect(Collectors.toList());
    }
}