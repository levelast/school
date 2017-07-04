package ru.improve.universityserver.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.improve.universityserver.domain.dao.AbstractCrudDao;
import ru.improve.universityserver.mapper.dto.BaseDtoMapper;

public abstract class AbstractRestController<Pojo, Dto, Id> {

    @GetMapping("{id}")
    public Dto get(@PathVariable Id id) {
        return getMapper().toDto(getDao().findOneWithDependencies(id));
    }

    @PostMapping
    public void save(@RequestBody Dto dto) {
        getDao().saveWithDependencies(getMapper().toPojo(dto));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Id id) {
        getDao().delete(id);
    }

    protected abstract AbstractCrudDao<Pojo, Id> getDao();
    protected abstract BaseDtoMapper<Pojo, Dto> getMapper();

    public static final class PathConstant {
        public static final String SUBJECT_PATH = "subject";
        public static final String TEACHER_PATH = "teacher";

        private PathConstant() {
        }
    }
}
