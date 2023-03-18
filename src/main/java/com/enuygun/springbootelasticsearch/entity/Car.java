package com.enuygun.springbootelasticsearch.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Data @NoArgsConstructor @RequiredArgsConstructor
public class Car {

    @NonNull
    private String brand;

    @NonNull
    private String color;

    @NonNull
    private String type;

    private int price;

    private boolean available;

    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "Asia/Jakarta")
    //@JsonProperty("first_release_date")
    private LocalDate firstReleaseDate;

    //@JsonProperty("additional_features")
    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    private List<String> additionalFeatures;

    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    private String secretFeature;

    @JsonUnwrapped
    private Engine engine;

    private List<Tire> tires;

}
