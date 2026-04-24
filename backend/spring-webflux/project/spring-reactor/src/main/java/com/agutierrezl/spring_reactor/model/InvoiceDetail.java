package com.agutierrezl.spring_reactor.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class InvoiceDetail {

    private int quantity;
    private Dish dish;
}
