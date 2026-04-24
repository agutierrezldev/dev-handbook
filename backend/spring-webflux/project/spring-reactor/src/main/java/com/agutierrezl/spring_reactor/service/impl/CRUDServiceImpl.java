package com.agutierrezl.spring_reactor.service.impl;

import com.agutierrezl.spring_reactor.repository.IGenericRepository;
import com.agutierrezl.spring_reactor.service.ICRUDService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public abstract class CRUDServiceImpl<T, ID> implements ICRUDService<T, ID> {

    abstract IGenericRepository<T,ID> getRepository();

    @Override
    public Mono<T> save(T t) {
        return this.getRepository().save(t);
    }

    @Override
    public Mono<T> update(ID id, T t) {
        return this.getRepository().save(t);
    }

    @Override
    public Flux<T> getAll() {
        return this.getRepository().findAll();
    }

    @Override
    public Mono<T> getById(ID id) {
        return this.getRepository().findById(id);
    }

    @Override
    public Mono<Boolean> delete(ID id) {
        return this.getRepository().deleteById(id)
                .thenReturn(true);
    }
}
