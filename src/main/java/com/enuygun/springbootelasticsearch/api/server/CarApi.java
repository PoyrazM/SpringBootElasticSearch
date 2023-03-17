package com.enuygun.springbootelasticsearch.api.server;

import com.enuygun.springbootelasticsearch.entity.Car;
import com.enuygun.springbootelasticsearch.service.CarService;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Data
@RequestMapping(value = "api/car/v1")
@RestController
public class CarApi {

    private static final Logger LOG = LoggerFactory.getLogger(CarApi.class);

    private final CarService carService;

    //@RequestMapping(value = "/random", method = RequestMethod.GET)
    @GetMapping(value = "/random", produces = MediaType.APPLICATION_JSON_VALUE)
    public Car random() {
       return carService.generateCar();
    }


    @PostMapping(value = "/echo", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String echo(@RequestBody Car car) {
        LOG.info("Car is {}", car);
        return car.toString();
    }

}
