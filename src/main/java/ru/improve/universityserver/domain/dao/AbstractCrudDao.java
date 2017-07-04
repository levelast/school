package ru.improve.universityserver.domain.dao;

import org.springframework.transaction.annotation.Transactional;
import ru.improve.universityserver.domain.repository.CrudRepository;

public abstract class AbstractCrudDao<Entity, Id> implements CrudRepository<Entity, Id> {

    @Override
    public Entity findOne(Id id) {
        return getRepository().findOne(id);
    }

    @Override
    public Entity findOneWithDependencies(Id id) {
        return getRepository().findOneWithDependencies(id);
    }

    @Override
    @Transactional
    public void save(Entity entity) {
        getRepository().save(entity);
    }

    @Override
    public void delete(Id id) {
        getRepository().delete(id);
    }

    @Override
    @Transactional
    public abstract void saveWithDependencies(Entity entity);

    protected abstract CrudRepository<Entity, Id> getRepository();
}
