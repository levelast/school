package ru.improve.universityserver.mapper.dto;

import org.mapstruct.Mapper;
import ru.improve.universityserver.domain.entity.Teacher;
import ru.improve.universityserver.dto.TeacherDto;

@Mapper(componentModel = "spring", uses = SubjectDtoMapper.class)
public interface TeacherDtoMapper extends BaseDtoMapper<Teacher, TeacherDto> {

}
