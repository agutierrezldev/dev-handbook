package com.agutierrezl.spring_reactor.mapper;


public interface IGenericMapper <T,R>{
    T convertDTOToEntity(R dto, Class<T> classEntity);
    R convertEntityToDTO(T entity, Class<R> classDTO);
}
