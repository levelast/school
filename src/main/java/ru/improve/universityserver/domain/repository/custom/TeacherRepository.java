package ru.improve.universityserver.domain.repository.custom;

import org.apache.ibatis.annotations.Mapper;
import ru.improve.universityserver.domain.entity.Teacher;
import ru.improve.universityserver.domain.repository.CrudRepository;

@Mapper
public interface TeacherRepository extends CrudRepository<Teacher, Long> {
}
