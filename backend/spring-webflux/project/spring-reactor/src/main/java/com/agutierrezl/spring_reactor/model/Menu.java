package com.agutierrezl.spring_reactor.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Document(collection = "menus")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Menu {

    @Id
    @EqualsAndHashCode.Include
    private String id;

    @Field
    private String icon;

    @Field
    private String name;

    @Field
    private String url;

    @Field
    private List<String> roles;
}
