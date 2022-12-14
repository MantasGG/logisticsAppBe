package com.university.logisticsappbe.repository;

import com.university.logisticsappbe.model.domain.DtoForum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ForumRepository extends JpaRepository<DtoForum, Long> {
    @Query(value = "SELECT r.reservation_id, r.user_email, r.desk_id, d.desk_name, ro.room_id, ro.room_name, r.reservation_start, r.reservation_end " +
            "FROM reservations r " +
            "JOIN desk d ON d.desk_id = r.desk_id " +
            "JOIN rooms ro ON ro.room_id = d.room_id " +
            "WHERE user_email = :userEmail",
            nativeQuery = true)
    List<DtoForum> findAllUserReservations(String userEmail);
}
