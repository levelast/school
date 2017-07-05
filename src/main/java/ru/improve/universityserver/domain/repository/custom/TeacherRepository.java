package ru.improve.universityserver.domain.repository.custom;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import ru.improve.universityserver.domain.entity.Teacher;
import ru.improve.universityserver.domain.repository.CrudRepository;
import ru.improve.universityserver.dto.filter.TeacherFilter;

import java.util.List;

@Mapper
public interface TeacherRepository extends CrudRepository<Teacher, Long> {

    String getName(@Param("id") Long id);

    List<Teacher> findByFilter(@Param("filter") TeacherFilter filter);
}
