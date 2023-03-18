package com.enuygun.springbootelasticsearch.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties(value = {"color", "serialNumber"})
public class Engine {

    private String fuelType;

    private int horsePower;

    private String color = "Black";

    private String serialNumber = "SJKAH252SZX";

}
