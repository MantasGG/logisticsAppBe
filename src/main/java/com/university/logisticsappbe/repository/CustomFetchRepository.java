package com.university.logisticsappbe.repository;

import com.university.logisticsappbe.model.domain.DtoForum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomFetchRepository extends JpaRepository<DtoForum, Long> {


}
