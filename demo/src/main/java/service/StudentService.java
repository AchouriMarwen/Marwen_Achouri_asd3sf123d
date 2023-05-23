package service;

import entities.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<Student> getStudents(String className, String teacherFullName, int page, int size);
}
