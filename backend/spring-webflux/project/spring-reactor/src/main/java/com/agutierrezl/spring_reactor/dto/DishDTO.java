package com.agutierrezl.spring_reactor.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DishDTO {

    private String id;
    @NotNull
    @Size(min = 2 , max = 20)
    private String nameDish;
    private Double priceDish;
    private Boolean status;
}
