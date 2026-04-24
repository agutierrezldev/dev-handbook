package com.agutierrezl.spring_reactor.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICRUDService<T,ID> {
    Mono<T> save (T t);
    Mono<T> update (ID id, T t);
    Flux<T> getAll ();
    Mono<T> getById (ID id);
    Mono<Boolean> delete (ID id);
}
