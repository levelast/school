package ru.improve.universityserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.improve.universityserver.domain.dao.AbstractCrudDao;
import ru.improve.universityserver.domain.dao.custom.SubjectDao;
import ru.improve.universityserver.domain.entity.Subject;
import ru.improve.universityserver.dto.SubjectDto;
import ru.improve.universityserver.mapper.dto.BaseDtoMapper;
import ru.improve.universityserver.mapper.dto.SubjectDtoMapper;

import static ru.improve.universityserver.controller.AbstractRestController.PathConstant.SUBJECT_PATH;

@RestController
@RequestMapping(SUBJECT_PATH)
public class SubjectController extends AbstractRestController<Subject, SubjectDto, Long> {

    private final SubjectDao subjectDao;
    private final SubjectDtoMapper subjectDtoMapper;

    @Autowired
    public SubjectController(SubjectDao subjectDao, SubjectDtoMapper subjectDtoMapper) {
        this.subjectDao = subjectDao;
        this.subjectDtoMapper = subjectDtoMapper;
    }

    @Override
    protected AbstractCrudDao<Subject, Long> getDao() {
        return subjectDao;
    }

    @Override
    protected BaseDtoMapper<Subject, SubjectDto> getMapper() {
        return subjectDtoMapper;
    }
}
