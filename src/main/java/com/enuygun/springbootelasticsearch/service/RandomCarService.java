package com.enuygun.springbootelasticsearch.service;

import com.enuygun.springbootelasticsearch.entity.Car;
import com.enuygun.springbootelasticsearch.util.RandomDateUtil;
import org.springframework.stereotype.Service;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class RandomCarService implements CarService{

    @Override
    public Car generateCar() {

        var brand = BRANDS.get(ThreadLocalRandom.current().nextInt(0, BRANDS.size()));
        var color = COLORS.get(ThreadLocalRandom.current().nextInt(0, COLORS.size()));
        var types = TYPES.get(ThreadLocalRandom.current().nextInt(0, TYPES.size()));

        var available = ThreadLocalRandom.current().nextBoolean();
        var price = ThreadLocalRandom.current().nextInt(5000, 12001);
        var firstReleaseDate = RandomDateUtil.generateRandomLocalDate();

        var result = new Car(brand, color, types);
        result.setAvailable(available);
        result.setPrice(price);
        result.setFirstReleaseDate(firstReleaseDate);

        return result;
    }
}
