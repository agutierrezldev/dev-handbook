package com.agutierrezl.spring_reactor.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Document(collection = "invoices")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Invoice {

    @Id
    @EqualsAndHashCode.Include
    private String id;

    @Field
    private String description;

    @Field
    private Client client;

    @Field
    private List<InvoiceDetail> items;
}
