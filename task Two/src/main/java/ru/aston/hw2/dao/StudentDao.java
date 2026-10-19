package ru.aston.hw2.dao;

import ru.aston.hw2.model.Student;
import ru.aston.hw2.service.StudentService;
import java.util.List;

public class StudentDao implements CrudDao<Student, Long> {
    private final StudentService studentService = new StudentService();

    @Override
    public void create(Student entity) {
        studentService.create(entity);
    }

    @Override
    public Student findById(Long id) {
        return studentService.findById(id).get();
    }

    @Override
    public void update(Student entity) {
        studentService.update(entity);

    }

    @Override
    public void delete(Student entity) {
        studentService.delete(entity);
    }

    public List<Student> findAll() {
        return studentService.convertFromJsonToList();
    }
}
