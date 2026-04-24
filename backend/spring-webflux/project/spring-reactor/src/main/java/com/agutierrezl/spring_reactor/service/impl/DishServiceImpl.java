package com.agutierrezl.spring_reactor.service.impl;

import com.agutierrezl.spring_reactor.model.Dish;
import com.agutierrezl.spring_reactor.repository.IDishRepository;
import com.agutierrezl.spring_reactor.repository.IGenericRepository;
import com.agutierrezl.spring_reactor.service.IDishService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class DishServiceImpl extends CRUDServiceImpl<Dish, String> implements IDishService {

    private final IDishRepository iDishRepository;
    private String text; // no tiene la palabra reservada final entonces no sera enviada por constructor

    @Override
    IGenericRepository<Dish, String> getRepository() {
        return this.iDishRepository;
    }

//    @Override
//    public Mono<Dish> save(Dish dish) {
//        return iDishRepository.save(dish);
//    }
//
//    @Override
//    public Mono<Dish> update(String id, Dish dish) {
//        dish.setId(id);
//        return iDishRepository.save(dish);
//    }
//
//    @Override
//    public Flux<Dish> getAll() {
//        return iDishRepository.findAll();
//    }
//
//    @Override
//    public Mono<Dish> getById(String id) {
//        return iDishRepository.findById(id);
//    }
//
//    @Override
//    public Mono<Boolean> delete(String id) {
//        return iDishRepository.deleteById(id).then(Mono.just(true));
//        // return iDishRepository.deleteById(id).thenReturn(true);
//    }
}
