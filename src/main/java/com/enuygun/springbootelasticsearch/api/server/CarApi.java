package com.enuygun.springbootelasticsearch.api.server;

import com.enuygun.springbootelasticsearch.entity.Car;
import com.enuygun.springbootelasticsearch.service.CarService;
import lombok.Data;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RequestMapping(value = "api/car/v1")
@RestController
public class CarApi {

    private final CarService carService;

    //@RequestMapping(value = "/random", method = RequestMethod.GET)
    @GetMapping(value = "/random", produces = MediaType.APPLICATION_JSON_VALUE)
    public Car random() {
       return carService.generateCar();
    }
}
