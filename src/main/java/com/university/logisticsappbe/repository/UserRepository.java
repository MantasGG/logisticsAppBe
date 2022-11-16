package com.university.logisticsappbe.repository;

import com.university.logisticsappbe.model.domain.DtoUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<DtoUser, Long> { }
