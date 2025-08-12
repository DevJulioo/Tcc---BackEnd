package com.example.dashboard.repository;

import com.example.dashboard.domain.Dashboard;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DashboardRepository extends JpaRepository<Dashboard, Long> {
    Optional<Dashboard> findByNameIgnoreCase(String name);
}