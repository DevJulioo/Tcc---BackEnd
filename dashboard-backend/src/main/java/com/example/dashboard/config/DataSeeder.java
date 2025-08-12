package com.example.dashboard.config;

import com.example.dashboard.domain.Dashboard;
import com.example.dashboard.domain.Widget;
import com.example.dashboard.domain.Widget.WidgetType;
import com.example.dashboard.repository.DashboardRepository;
import com.example.dashboard.repository.WidgetRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    private final DashboardRepository dashboardRepository;
    private final WidgetRepository widgetRepository;

    public DataSeeder(DashboardRepository dashboardRepository, WidgetRepository widgetRepository) {
        this.dashboardRepository = dashboardRepository;
        this.widgetRepository = widgetRepository;
    }

    @PostConstruct
    public void seed() {
        if (dashboardRepository.count() == 0) {
            Dashboard d = new Dashboard();
            d.setName("Principal");
            d.setLayoutJson("{}");
            dashboardRepository.save(d);
        }

        if (widgetRepository.count() == 0) {
            Widget kpi = new Widget();
            kpi.setTitle("Vendas Hoje");
            kpi.setType(WidgetType.KPI);
            kpi.setConfigJson("""
                    {"query":"SELECT SUM(valor) FROM vendas WHERE data = CURRENT_DATE"}
                    """);
            widgetRepository.save(kpi);

            Widget line = new Widget();
            line.setTitle("Vendas por Dia");
            line.setType(WidgetType.CHART_LINE);
            line.setConfigJson("""
                    {"query":"SELECT data, SUM(valor) FROM vendas GROUP BY data ORDER BY data"}
                    """);
            widgetRepository.save(line);
        }
    }
}