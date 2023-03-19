package com.enuygun.springbootelasticsearch.repository;

import com.enuygun.springbootelasticsearch.entity.Car;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract class CarElasticRepository implements ElasticsearchRepository<Car, String> {

}
