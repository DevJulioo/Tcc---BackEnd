package com.example.dashboard.repository;

import com.example.dashboard.domain.Widget;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WidgetRepository extends JpaRepository<Widget, Long> {}