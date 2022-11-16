package com.university.logisticsappbe.controller;

import com.university.logisticsappbe.model.api.CreateRouteRequest;
import com.university.logisticsappbe.model.domain.DtoRoutes;
import com.university.logisticsappbe.service.RoutesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
public class RoutesController {
    private final RoutesService routesService;

    @Autowired
    public RoutesController(RoutesService routesService) {
        this.routesService = routesService;
    }

    @GetMapping(path = "/routes")
    public List<DtoRoutes> fetchRoutes(){
        return routesService.fetchRoutes();
    }

    @PostMapping(path = "/routes")
    public Long createRoute(@Validated @RequestBody CreateRouteRequest request){
        return routesService.createRoute(request).getId();
    }

    @PutMapping(path = "/routes/{id}")
    public DtoRoutes updateRoute(@Validated @RequestBody DtoRoutes route, @PathVariable Long id){
        return routesService.updateRoute(route,id);
    }

    @DeleteMapping(value = "/routes/{id}")
    public ResponseEntity<Void> deleteRoute(@PathVariable Long id){
        routesService.deleteRoute(id);
        return ResponseEntity.noContent().build();
    }
}
