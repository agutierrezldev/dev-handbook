package com.agutierrezl.spring_reactor.repository;

import com.agutierrezl.spring_reactor.model.Client;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends IGenericRepository<Client,String> {
}
