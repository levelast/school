package ru.improve.universityserver.domain.dao.custom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.improve.universityserver.domain.entity.Subject;
import ru.improve.universityserver.domain.dao.AbstractCrudDao;
import ru.improve.universityserver.domain.repository.CrudRepository;
import ru.improve.universityserver.domain.repository.custom.SubjectRepository;

@Repository
public class SubjectDao extends AbstractCrudDao<Subject, Long> {

    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectDao(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    @Transactional
    public void saveWithDependencies(Subject subject) {
        subjectRepository.save(subject);
    }

    @Override
    protected CrudRepository<Subject, Long> getRepository() {
        return subjectRepository;
    }
}
