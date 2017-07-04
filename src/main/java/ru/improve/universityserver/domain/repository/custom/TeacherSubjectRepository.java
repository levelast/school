package ru.improve.universityserver.domain.repository.custom;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TeacherSubjectRepository {

    void save(@Param("teacherId") Long teacherId, @Param("subjectId") Long subjectId);

    void deleteByTeacherId(@Param("teacherId") Long teacherId);
}
