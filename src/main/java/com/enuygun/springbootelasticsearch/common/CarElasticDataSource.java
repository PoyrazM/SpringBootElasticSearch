package com.enuygun.springbootelasticsearch.common;

import com.enuygun.springbootelasticsearch.entity.Car;
import com.enuygun.springbootelasticsearch.repository.CarElasticRepository;
import com.enuygun.springbootelasticsearch.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;
import java.util.ArrayList;

@Component
public class CarElasticDataSource {

    private static final Logger LOG = LoggerFactory.getLogger(CarElasticDataSource.class);

    @Autowired(required = false)
    private CarElasticRepository carElasticRepository;

    @Autowired
    @Qualifier(value = "randomCarService")
    private CarService carService;

    @Autowired
    @Qualifier(value = "webClientElasticsearch")
    private WebClient webClient;

    @EventListener(ApplicationReadyEvent.class)
    public void populateData() {


        var response = webClient.delete().uri("/my_index").retrieve().bodyToMono(String.class).block();
        LOG.info("End delete with response {}", response);

        var cars = new ArrayList<Car>();

        for (int i = 0; i < 10_000; i++) {
            cars.add(carService.generateCar());
        }

        carElasticRepository.saveAll(cars);

        LOG.info("Saved {} cars", carElasticRepository.count());
    }
}
