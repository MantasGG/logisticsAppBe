package com.university.logisticsappbe.repository;

import com.university.logisticsappbe.model.domain.DtoRoutes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RoutesRepository extends JpaRepository<DtoRoutes, Long> {
    List<DtoRoutes> findAllByAssignedUserId(Long email);
    List<DtoRoutes> findAllByAssignedUserIdIsNull();

    @Transactional
    @Modifying
    @Query("update ROUTES r set r.assignedUserId = :assignedUserId WHERE r.id = :id")
    int updateRoute(Long id, Long assignedUserId);

    @Transactional
    @Modifying
    @Query("update ROUTES r set r.assignedUserId = null WHERE r.id = :id")
    int updateRouteRemoveAssignedUserId(Long id);



//    UPDATE Customers
//    SET ContactName = 'Alfred Schmidt', City= 'Frankfurt'
//    WHERE CustomerID = 1;
}
