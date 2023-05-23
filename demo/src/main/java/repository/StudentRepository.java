package repository;

import entities.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.net.ContentHandler;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    ContentHandler findAll(Specification<Student> specification, Pageable pageable);
    // Implement custom queries if needed
}

