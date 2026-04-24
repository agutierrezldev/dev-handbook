package com.agutierrezl.spring_reactor.controller;

import com.agutierrezl.spring_reactor.dto.DishDTO;
import com.agutierrezl.spring_reactor.mapper.DishMapper;
import com.agutierrezl.spring_reactor.service.IDishService;
import jakarta.validation.Valid;
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
    private final DishMapper iDishMapper;

    @GetMapping
    public Mono<ResponseEntity<Flux<DishDTO>>> findAll() {
        Flux<DishDTO> fx = iDishService.getAll()
                .map(iDishMapper::convertEntityToDTO);

        return Mono.just(ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(fx))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<DishDTO>> findById(@PathVariable("id") String id) {
        return iDishService.getById(id)
                .map(iDishMapper::convertEntityToDTO)
                // .doOnNext(System.out::println)
                .map(e -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(e))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<ResponseEntity<DishDTO>> save(@Valid @RequestBody DishDTO dishDTO) {
        return iDishService.save(iDishMapper.convertDTOToEntity(dishDTO))
                .map(iDishMapper::convertEntityToDTO)
                .map(e -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(e));
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<DishDTO>> update(@PathVariable("id") String id, @RequestBody DishDTO dishDTO) {
        return Mono.just(dishDTO)
                .map(e -> {
                    e.setId(id);
                    return e;
                })
                .flatMap(e -> iDishService.update(id, iDishMapper.convertDTOToEntity(e)))
                .map(iDishMapper::convertEntityToDTO)
                .map(e -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(e))
                .defaultIfEmpty(ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable("id") String id) {
//        return iDishService.delete(id)
//                .flatMap(result -> {
//                    if (result) {
//                        return Mono.just(ResponseEntity.noContent().build());
//                    }else {
//                        return Mono.just(ResponseEntity.notFound().build());
//                    }
//                });

        return iDishService.delete(id)
                .map(result -> {
                    if (result) {
                        return ResponseEntity.noContent().build();
                    } else {
                        return ResponseEntity.notFound().build();
                    }
                });

    }

//    private DishDTO convertEntityToDTO(Dish dish) {
//        return modelMapper.map(dish, DishDTO.class);
//    }
//
//    private Dish convertDTOToEntity(DishDTO dishDTO) {
//        return modelMapper.map(dishDTO, Dish.class);
//    }
}
