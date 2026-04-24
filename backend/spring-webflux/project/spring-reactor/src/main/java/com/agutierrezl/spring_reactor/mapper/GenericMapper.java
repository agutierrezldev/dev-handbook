package com.agutierrezl.spring_reactor.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

@RequiredArgsConstructor
public abstract class GenericMapper<T,R> {

    private final ModelMapper modelMapper;
    private final Class<T> entityClass;
    private final Class<R> dtoClass;

    public T convertDTOToEntity(R dto) {
        return modelMapper.map(dto,entityClass);
    }

    public R convertEntityToDTO(T entity) {
        return modelMapper.map(entity, dtoClass);
    }

}
