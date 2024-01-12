package ru.savrey.springbootproject1.homework;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component("myStudentRepo")
public class StudentRepository {
    private final List<Student> students;

    public StudentRepository() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void deleteStudent(long id) {
        students.stream().filter(it -> Objects.equals(it.getId(), id))
                .findFirst().ifPresent(students::remove);
    }

    public List<Student> getAll() {
        return List.copyOf(students);
    }

    public Student getById(long id) {
        return students.stream()
                .filter(it -> Objects.equals(it.getId(), id))
                .findFirst()
                .orElse(null);
    }

    public List<Student> getByName(String name) {
        List<Student> result;
        result = students.stream().filter(it -> it.getName().contains(name)).toList();
        return result;
    }

    public List<Student> getByGroup(String groupName) {
        List<Student> result;
        result = students.stream().filter(it -> Objects.equals(it.getGroupName(), groupName)).toList();
        return result;
    }
}
