package com.enuygun.springbootelasticsearch.entity;

import com.enuygun.springbootelasticsearch.repository.CarElasticRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;
import java.util.List;

@Document(indexName = "spring-boot-elasticsearch")
@Data @NoArgsConstructor @RequiredArgsConstructor
public class Car {

    @Id
    private String id;

    @NonNull
    private String brand;

    @NonNull
    private String color;

    @NonNull
    private String type;

    private int price;

    private boolean available;

    @Field(type = FieldType.Date, format = DateFormat.date)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Jakarta")
    private LocalDate firstReleaseDate;

    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    private List<String> additionalFeatures;

    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    private String secretFeature;

    @JsonUnwrapped
    private Engine engine;

    private List<Tire> tires;

}
