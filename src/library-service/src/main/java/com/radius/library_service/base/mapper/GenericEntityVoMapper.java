package com.radius.library_service.base.mapper;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public abstract class GenericEntityVoMapper<E, V>{

    protected abstract List<Consumer<V>> getEntityToVoMappers(E entity);

    protected abstract List<Consumer<E>> getVoToEntityMappers(V vo);

    protected abstract List<Consumer<E>> getVoToEntityPartialMappers(V vo);

    public V mapToVo(E entity) {
        V vo = createVoInstance();
        getEntityToVoMappers(entity).forEach(mapper -> mapper.accept(vo));
        return vo;
    }

    public E mapToEntity(V vo) {
        E entity = createEntityInstance();
        getVoToEntityMappers(vo).forEach(mapper -> mapper.accept(entity));
        return entity;
    }

    public List<V> mapToVoList(List<E> entities) {
        return entities.stream().map(this::mapToVo).collect(Collectors.toList());
    }

    public List<E> mapToEntityList(List<V> vos) {
        return vos.stream().map(this::mapToEntity).collect(Collectors.toList());
    }

    public void updateEntity(E existingEntity, V partialVo) {
        getVoToEntityPartialMappers(partialVo).forEach(mapper -> mapper.accept(existingEntity));
    }

    protected abstract V createVoInstance();
    protected abstract E createEntityInstance();
}
