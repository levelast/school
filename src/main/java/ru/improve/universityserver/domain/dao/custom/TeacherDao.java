package ru.improve.universityserver.domain.dao.custom;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.improve.universityserver.domain.dao.AbstractCrudDao;
import ru.improve.universityserver.domain.entity.Subject;
import ru.improve.universityserver.domain.entity.Teacher;
import ru.improve.universityserver.domain.repository.CrudRepository;
import ru.improve.universityserver.domain.repository.custom.TeacherRepository;
import ru.improve.universityserver.domain.repository.custom.TeacherSubjectRepository;

import java.util.List;

@Repository
public class TeacherDao extends AbstractCrudDao<Teacher, Long> {

    private final TeacherRepository teacherRepository;
    private final TeacherSubjectRepository teacherSubjectRepository;

    @Autowired
    public TeacherDao(TeacherRepository teacherRepository, TeacherSubjectRepository teacherSubjectRepository) {
        this.teacherRepository = teacherRepository;
        this.teacherSubjectRepository = teacherSubjectRepository;
    }

    @Override
    @Transactional
    public void saveWithDependencies(Teacher teacher) {
        if (teacher.getId() != null) {
            teacherSubjectRepository.deleteByTeacherId(teacher.getId());
        }
        teacherRepository.save(teacher);
        List<Subject> subjects = teacher.getSubjects();
        if (CollectionUtils.isNotEmpty(subjects)) {
            subjects.forEach(subject -> teacherSubjectRepository.save(teacher.getId(), subject.getId()));
        }
    }

    @Override
    protected CrudRepository<Teacher, Long> getRepository() {
        return teacherRepository;
    }
}
