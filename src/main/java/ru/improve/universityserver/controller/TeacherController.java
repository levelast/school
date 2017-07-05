package ru.improve.universityserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.improve.universityserver.domain.dao.AbstractCrudDao;
import ru.improve.universityserver.domain.dao.custom.TeacherDao;
import ru.improve.universityserver.domain.entity.Teacher;
import ru.improve.universityserver.dto.TeacherDto;
import ru.improve.universityserver.dto.filter.TeacherFilter;
import ru.improve.universityserver.mapper.dto.BaseDtoMapper;
import ru.improve.universityserver.mapper.dto.TeacherDtoMapper;

import java.util.List;

import static ru.improve.universityserver.controller.AbstractRestController.PathConstant.TEACHER_PATH;

@RestController
@RequestMapping(TEACHER_PATH)
public class TeacherController extends AbstractRestController<Teacher, TeacherDto, Long> {

    private final TeacherDao teacherDao;
    private final TeacherDtoMapper teacherDtoMapper;

    @Autowired
    public TeacherController(TeacherDao teacherDao, TeacherDtoMapper teacherDtoMapper) {
        this.teacherDao = teacherDao;
        this.teacherDtoMapper = teacherDtoMapper;
    }

    @GetMapping("getName")
    public String getName(@RequestParam("id") Long id) {
        return teacherDao.getName(id);
    }

    @PostMapping("filter")
    public List<TeacherDto> findByFilter(@RequestBody TeacherFilter filter) {
        return teacherDtoMapper.toDtoList(teacherDao.findByFilter(filter));
    }

    @Override
    protected AbstractCrudDao<Teacher, Long> getDao() {
        return teacherDao;
    }

    @Override
    protected BaseDtoMapper<Teacher, TeacherDto> getMapper() {
        return teacherDtoMapper;
    }
}
