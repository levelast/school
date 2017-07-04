package ru.improve.universityserver.domain.repository.custom;

import org.apache.ibatis.annotations.Mapper;
import ru.improve.universityserver.domain.entity.Subject;
import ru.improve.universityserver.domain.repository.CrudRepository;

@Mapper
public interface SubjectRepository extends CrudRepository<Subject, Long> {
}
