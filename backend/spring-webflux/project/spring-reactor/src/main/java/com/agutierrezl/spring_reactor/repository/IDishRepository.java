package com.agutierrezl.spring_reactor.repository;

import com.agutierrezl.spring_reactor.model.Dish;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDishRepository extends ReactiveMongoRepository<Dish,String> {
}
