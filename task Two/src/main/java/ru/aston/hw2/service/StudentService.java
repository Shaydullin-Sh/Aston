package ru.aston.hw2.service;

import ru.aston.hw2.data.Database;
import ru.aston.hw2.exception.StudentNotFoundException;
import ru.aston.hw2.model.Student;
import java.util.List;
import java.util.Optional;

public class StudentService {
    private final Database database = new Database();
    private final List<Student> students = database.getStudents();

    public void create(Student entity) {
        if (findById(entity.getId()).isPresent()) {
            System.out.println("Данный студент уже в списке!");
            return;
        }
        students.add(entity);
        database.saveStudents(students);
    }

    public Optional<Student>  findById(Long id) {
        return Optional.ofNullable(students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new StudentNotFoundException(id))
                );
    }

    public void update(Student entity) {
        if (findById(entity.getId()).isEmpty()) {return;}
        students.set(students.indexOf(findById(entity.getId()).get()), entity);
        database.saveStudents(students);
    }

    public void delete(Student entity) {
        if (findById(entity.getId()).isEmpty()) {return;}
        students.remove(entity);
        database.saveStudents(students);
    }
    public List<Student> convertFromJsonToList() {
        return students;
    }
}
