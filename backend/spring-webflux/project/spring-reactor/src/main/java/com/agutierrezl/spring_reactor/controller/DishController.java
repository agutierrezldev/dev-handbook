package com.agutierrezl.spring_reactor.controller;

import com.agutierrezl.spring_reactor.model.Dish;
import com.agutierrezl.spring_reactor.service.IDishService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/dishes")
@RequiredArgsConstructor
public class DishController {
    private final IDishService iDishService;

    @GetMapping
    public Mono<ResponseEntity<Flux<Dish>>> findAll() {
        return Mono.just(ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(iDishService.getAll()))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Dish>> findById(@PathVariable("id") String id) {
        return iDishService.getById(id)
                // .doOnNext(System.out::println)
                .map(e -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(e))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<ResponseEntity<Dish>> save(@RequestBody Dish dish) {
        return iDishService.save(dish)
                .map(e -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(e))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Mono<Dish> update(@PathVariable("id") String id, @RequestBody Dish dish) {
        return iDishService.update(id, dish);
    }

    @DeleteMapping("/{id}")
    public Mono<Boolean> delete(@PathVariable("id") String id) {
        return iDishService.delete(id);
    }
}
