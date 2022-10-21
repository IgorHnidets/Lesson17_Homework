package components;

import components.Student;
import org.springframework.stereotype.Component;

import java.util.List;

public interface DaoStudent {

    Student getStudentById(int id);

    List<Student> getAllStudents();
    void add(Student student);
    void remove(int id);
}
