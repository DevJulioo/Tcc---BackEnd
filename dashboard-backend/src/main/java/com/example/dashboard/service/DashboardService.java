package com.example.dashboard.service;

import com.example.dashboard.domain.Dashboard;
import com.example.dashboard.domain.DashboardWidget;
import com.example.dashboard.domain.Widget;
import com.example.dashboard.repository.DashboardRepository;
import com.example.dashboard.repository.DashboardWidgetRepository;
import com.example.dashboard.repository.WidgetRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DashboardService {

    private final DashboardRepository dashboardRepository;
    private final WidgetRepository widgetRepository;
    private final DashboardWidgetRepository dashboardWidgetRepository;

    public DashboardService(
            DashboardRepository dashboardRepository,
            WidgetRepository widgetRepository,
            DashboardWidgetRepository dashboardWidgetRepository) {
        this.dashboardRepository = dashboardRepository;
        this.widgetRepository = widgetRepository;
        this.dashboardWidgetRepository = dashboardWidgetRepository;
    }

    @Transactional(readOnly = true)
    public List<Dashboard> listDashboards() {
        return dashboardRepository.findAll();
    }

    public Dashboard createDashboard(Dashboard dashboard) {
        return dashboardRepository.save(dashboard);
    }

    @Transactional(readOnly = true)
    public Dashboard getDashboard(Long id) {
        return dashboardRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Dashboard not found: " + id));
    }

    public Widget createWidget(Widget widget) {
        return widgetRepository.save(widget);
    }

    @Transactional(readOnly = true)
    public List<Widget> listWidgets() {
        return widgetRepository.findAll();
    }

    public DashboardWidget addWidgetToDashboard(Long dashboardId, Long widgetId, int x, int y, int w, int h) {
        Dashboard dashboard = getDashboard(dashboardId);
        Widget widget = widgetRepository.findById(widgetId)
                .orElseThrow(() -> new EntityNotFoundException("Widget not found: " + widgetId));

        DashboardWidget placement = new DashboardWidget();
        placement.setDashboard(dashboard);
        placement.setWidget(widget);
        placement.setPositionX(x);
        placement.setPositionY(y);
        placement.setWidth(w);
        placement.setHeight(h);
        return dashboardWidgetRepository.save(placement);
    }

    @Transactional(readOnly = true)
    public List<DashboardWidget> listWidgetsForDashboard(Long dashboardId) {
        return dashboardWidgetRepository.findByDashboardIdOrderByPositionYAscPositionXAsc(dashboardId);
    }
}