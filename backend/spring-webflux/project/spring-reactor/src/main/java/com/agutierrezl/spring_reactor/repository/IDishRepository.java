package com.agutierrezl.spring_reactor.repository;

import com.agutierrezl.spring_reactor.model.Dish;
import org.springframework.stereotype.Repository;

@Repository
public interface IDishRepository extends IGenericRepository<Dish,String> {
}
