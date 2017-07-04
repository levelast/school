package ru.improve.universityserver.mapper.dto;

import org.mapstruct.Mapper;
import ru.improve.universityserver.domain.entity.Subject;

@Mapper(componentModel = "spring")
public interface SubjectDtoMapper extends BaseDtoMapper<Subject, ru.improve.universityserver.dto.SubjectDto> {

}
