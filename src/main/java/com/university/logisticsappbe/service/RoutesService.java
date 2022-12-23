package com.university.logisticsappbe.service;

import com.university.logisticsappbe.model.api.CreateRouteRequest;
import com.university.logisticsappbe.model.domain.DtoRoutes;
import com.university.logisticsappbe.repository.RoutesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoutesService {
    private final RoutesRepository routesRepository;

    @Autowired
    public RoutesService(RoutesRepository routesRepository) {
        this.routesRepository = routesRepository;
    }

    public List<DtoRoutes> fetchRoutes(){
        return routesRepository.findAll();
    }

    public List<DtoRoutes> fetchAllByAssignedUserId(Long assignedUserId){
        return routesRepository.findAllByAssignedUserId(assignedUserId);
    }

    public List<DtoRoutes> fetchAllWhereAssignedUserIdIsNull(){
        return routesRepository.findAllByAssignedUserIdIsNull();
    }

    public DtoRoutes createRoute(CreateRouteRequest request){
        DtoRoutes route = DtoRoutes.builder()
                .assignedUserId(request.getAssignedUserId())
                .pointA(request.getPointA())
                .pointB(request.getPointB())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .status(request.getStatus())
                .build();

        return routesRepository.save(route);
    }

    public DtoRoutes updateRoute(DtoRoutes route, Long id){
        route.setId(id);
        return routesRepository.save(route);
    }

    public void deleteRoute(Long id){
        routesRepository.deleteById(id);
    }

    public int assignRoute(Long id, Long userId) {
        return routesRepository.updateRoute(id, userId);
    }

    public int unassignRoute(Long id){
        return routesRepository.updateRouteRemoveAssignedUserId(id);
    }
}
