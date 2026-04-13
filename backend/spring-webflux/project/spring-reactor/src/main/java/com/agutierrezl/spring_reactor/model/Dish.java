package com.agutierrezl.spring_reactor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@Document(collection = "dishes")
public class Dish {

    @Id
    private String id;

    @Field(name = "name")
    private String name;

    @Field
    private Double price;

    @Field
    private Boolean status;


}
