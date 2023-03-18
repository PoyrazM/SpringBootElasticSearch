package com.enuygun.springbootelasticsearch.service;

import com.enuygun.springbootelasticsearch.entity.Car;
import java.util.List;

public interface CarService {

    List<String> BRANDS = List.of("Toyota", "Honda", "Ford");

    List<String> COLORS = List.of("Red", "Black", "White");

    List<String> TYPES = List.of("Sedan", "SUV", "MPV");

    List<String> ADDITIONAL_FEATURES = List.of("GPS", "Alarm", "Sunroof", "Media Player", "Leather Seats");

    List<String> FUELS = List.of("Petrol", "Electric", "Hybrid");

    List<String> TIRE_MANUFACTURES = List.of("Goodyear", "Bridgestone", "Dunlop");

    Car generateCar();

}
