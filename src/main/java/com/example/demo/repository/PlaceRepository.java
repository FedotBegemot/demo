package com.example.demo.repository;

import com.example.demo.entity.Place;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PlaceRepository extends MongoRepository<Place, String> {

    public Place findByName(String name);

    public List<Place> findAll();

    public Place findByLocation(GeoJsonPoint point);
}