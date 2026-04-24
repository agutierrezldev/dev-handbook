package com.agutierrezl.spring_reactor.service;

import com.agutierrezl.spring_reactor.model.Dish;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface
IDishService  extends ICRUDService<Dish, String>{
//    Mono<Dish> save (Dish dish);
//    Mono<Dish> update (String id, Dish dish);
//    Flux<Dish> getAll ();
//    Mono<Dish> getById (String id);
//    Mono<Boolean> delete (String id);
}
