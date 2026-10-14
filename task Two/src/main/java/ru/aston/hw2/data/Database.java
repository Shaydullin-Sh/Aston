package ru.aston.hw2.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import ru.aston.hw2.model.Student;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private final ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    private final File file = new File("Database.json");

    public void initialize() {
        try {
            if (!file.exists()) {
                mapper.writeValue(file, new ArrayList<Student>());
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Student> getStudents() {
        initialize();
        try {
            return mapper.readValue(file, new TypeReference<List<Student>>() {
            });
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Файл Database.json пуст!");
        return new ArrayList<Student>();
    }

    public void saveStudents(List<Student> students) {
        try {
            mapper.writeValue(file, students);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
