package com.enuygun.springbootelasticsearch.entity;

import lombok.*;

import java.time.LocalDate;

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

    private LocalDate firstReleaseDate;

}
