package com.agutierrezl.spring_reactor.mapper;

import com.agutierrezl.spring_reactor.dto.DishDTO;
import com.agutierrezl.spring_reactor.model.Dish;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DishMapper extends GenericMapper<Dish, DishDTO>{

    public DishMapper(ModelMapper modelMapper) {
        super(modelMapper, Dish.class, DishDTO.class);
    }
}
