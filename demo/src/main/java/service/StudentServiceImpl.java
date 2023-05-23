package service;


import entities.Student;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import repository.StudentRepository;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getStudents(String className, String teacherFullName, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Specification<Student> specification = Specification.where(null);

        if (className != null && !className.isEmpty()) {
            specification = specification.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("schoolClass").get("name"), className));
        }

        if (teacherFullName != null && !teacherFullName.isEmpty()) {
            String[] names = teacherFullName.split(" ");
            String firstName = names[0];
            String lastName = names.length > 1 ? names[1] : "";

            specification = specification.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.and(
                            criteriaBuilder.equal(root.get("schoolClass").get("teacher").get("firstName"), firstName),
                            criteriaBuilder.equal(root.get("schoolClass").get("teacher").get("lastName"), lastName)
                    ));
        }

        return (List<Student>) studentRepository.findAll(specification, pageable);
    }
}
