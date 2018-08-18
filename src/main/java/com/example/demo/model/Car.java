package com.example.demo.model;

import lombok.*;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Car {

    private Integer id;
    private String brand; //get + field name (first uppercase letter) -> getBrand()
    private String model;
    private Integer year;
    private Integer kmRun;

    @Singular
    private List<String> previousOwners;
}
