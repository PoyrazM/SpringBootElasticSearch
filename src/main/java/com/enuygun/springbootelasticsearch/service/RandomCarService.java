package com.enuygun.springbootelasticsearch.service;

import com.enuygun.springbootelasticsearch.entity.Car;
import com.enuygun.springbootelasticsearch.entity.Engine;
import com.enuygun.springbootelasticsearch.entity.Tire;
import com.enuygun.springbootelasticsearch.repository.CarElasticRepository;
import com.enuygun.springbootelasticsearch.util.RandomDateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

@Service
@Component
public class RandomCarService implements CarService{

    @Override
    public Car generateCar() {

        var brand = BRANDS.get(ThreadLocalRandom.current().nextInt(0, BRANDS.size()));
        var color = COLORS.get(ThreadLocalRandom.current().nextInt(0, COLORS.size()));
        var types = TYPES.get(ThreadLocalRandom.current().nextInt(0, TYPES.size()));

        var available = ThreadLocalRandom.current().nextBoolean();
        var price = ThreadLocalRandom.current().nextInt(5000, 12001);
        var firstReleaseDate = RandomDateUtil.generateRandomLocalDate();

        int randomCount = ThreadLocalRandom.current().nextInt(ADDITIONAL_FEATURES.size());
        var additionalFeatures = new ArrayList<String>();

        for(int i = 0; i < randomCount; i++) {
            additionalFeatures.add(ADDITIONAL_FEATURES.get(i));
        }

        var fuel = FUELS.get(ThreadLocalRandom.current().nextInt(FUELS.size()));

        var horsePower = ThreadLocalRandom.current().nextInt(100, 221);

        var engine = new Engine();
        engine.setFuelType(fuel);
        engine.setHorsePower(horsePower);

        var tires = new ArrayList<Tire>();

        for (int i = 0; i < 3; i++) {
            var tire = new Tire();
            var manufacturer = TIRE_MANUFACTURES.get(ThreadLocalRandom.current().nextInt(TIRE_MANUFACTURES.size()));
            var size = ThreadLocalRandom.current().nextInt(15, 18);
            var tirePrice = ThreadLocalRandom.current().nextInt(200, 401);

            tire.setManufacture(manufacturer);
            tire.setPrice(tirePrice);
            tire.setSize(size);

            tires.add(tire);
        }

        var secretFeature = ThreadLocalRandom.current().nextBoolean() ? "Can fly" : null;

        var result = new Car(brand, color, types);
        result.setAvailable(available);
        result.setPrice(price);
        result.setFirstReleaseDate(firstReleaseDate);
        result.setAdditionalFeatures(additionalFeatures);
        result.setEngine(engine);
        result.setTires(tires);
        result.setSecretFeature(secretFeature);

        return result;
    }
}
