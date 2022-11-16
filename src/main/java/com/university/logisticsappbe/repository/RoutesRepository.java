package com.university.logisticsappbe.repository;

import com.university.logisticsappbe.model.domain.DtoRoutes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoutesRepository extends JpaRepository<DtoRoutes, Long> {
}
