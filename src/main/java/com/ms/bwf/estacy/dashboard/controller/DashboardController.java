package com.ms.bwf.estacy.dashboard.controller;

import com.ms.bwf.estacy.dashboard.services.DashboardServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DashboardController {

    @Autowired
    DashboardServices dashboardServices;

    @GetMapping(value = "/fetchVendorAvgRating", produces = "application/json")
    public ResponseEntity fetchAverageVendorRating(){
        return ResponseEntity.ok(dashboardServices.handleVendorAverageRatingRequest());
    }

    @GetMapping(value = "/fetchVendorAvgRating/{technology}", produces = "application/json")
    public ResponseEntity fetchAverageVendorRating(@PathVariable("technology") String technology){
        return ResponseEntity.ok(dashboardServices.handleVendorAverageRatingRequestByTechnology(technology));
    }

    @GetMapping(value = "/fetchTechnologyAvgRating", produces = "application/json")
    public ResponseEntity fetchTechnologyAvgRating(){
        return ResponseEntity.ok(dashboardServices.handleTechnologyAverageRatingRequest());
    }

    @GetMapping(value = "/fetchTechnologyAvgRating/{vendor}", produces = "application/json")
    public ResponseEntity fetchTechnologyAvgRating(@PathVariable("vendor") String vendor){
        return ResponseEntity.ok(dashboardServices.handleTechnologyAverageRatingByVendorRequest(vendor));
    }
}
