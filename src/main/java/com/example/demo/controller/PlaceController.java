package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Place;
import com.example.demo.repository.PlaceRepository;

import java.util.List;

@RestController
@RequestMapping("/places")
public class PlaceController {
    private final PlaceRepository placeRepository;

    @Autowired
    public PlaceController(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @PostMapping("/newplace")
    public void addPlaces(@RequestBody final List<Place> places) {
        placeRepository.saveAll(places);
    }

    @GetMapping("/allplaces")
    public List<Place> findPlaces() {
        return placeRepository.findAll();
    }

    @GetMapping("/{name}")
    public Place findPlace(@PathVariable final String name) {
        return placeRepository.findByName(name);
    }

    @GetMapping("/{location}")
    public Place findByLocation(@PathVariable final GeoJsonPoint location) {
        return placeRepository.findByLocation(location);
    }
}