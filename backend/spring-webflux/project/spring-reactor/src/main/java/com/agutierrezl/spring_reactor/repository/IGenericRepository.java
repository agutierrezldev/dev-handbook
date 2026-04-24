package com.agutierrezl.spring_reactor.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean // Es para que no cree un repository aun porque esta es una clase de conf ya que el T es de java.object.lang (clase padre)
public interface IGenericRepository<T,ID> extends ReactiveMongoRepository<T,ID> {
}
