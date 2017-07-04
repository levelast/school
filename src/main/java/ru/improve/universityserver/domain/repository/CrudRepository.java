package ru.improve.universityserver.domain.repository;

import org.apache.ibatis.annotations.Param;

public interface CrudRepository<Entity, Id> {

    Entity findOne(@Param("id") Id id);

    Entity findOneWithDependencies(@Param("id") Id id);

    void save(@Param("entity") Entity entity);

    void saveWithDependencies(@Param("entity") Entity entity);

    void delete(@Param("id") Id id);
}
