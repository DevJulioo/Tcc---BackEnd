package com.example.dashboard.repository;

import com.example.dashboard.domain.DashboardWidget;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DashboardWidgetRepository extends JpaRepository<DashboardWidget, Long> {
    List<DashboardWidget> findByDashboardIdOrderByPositionYAscPositionXAsc(Long dashboardId);
}