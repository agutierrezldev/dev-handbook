package com.agutierrezl.spring_reactor.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Data
@Document(collection = "roles")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Role {

    @Id
    @EqualsAndHashCode.Include
    private String id;

    @Field
    private String name;
}
