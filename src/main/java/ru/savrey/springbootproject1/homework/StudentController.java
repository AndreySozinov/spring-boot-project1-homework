package ru.savrey.springbootproject1.homework;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 1. Создать spring-boot приложение с помощью https://start.spring.io/
 * 2. Создать Класс Student c полями: идентификатор, имя, имя группы
 * 3. Создать контроллер, обрабатывающий входящие запросы:
 * 3.1 GET /student/{id} - получить студента по ID
 * 3.2 GET /student - получить всех студентов
 * 3.3 GET /student/search?name='studentName' - получить список студентов, чье имя содержит подстроку studentName
 * 3.4 GET /group/{groupName}/student - получить всех студентов группы
 * 3.5 POST /student - создать студента (принимает JSON) (отладиться можно с помощью Postman)
 * 3.6 DELETE /student/{id} - удалить студента
 * 4. При старте приложения, в программе должно быть создано 5-10 студентов.
 */
@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentRepository studentRepository;

    @GetMapping(path = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String hello() {
        return """
               <h1>Students Repository</h1>
               <h2>possible resources</h2>
               <h3>/student/{id} - получить студента по ID</h3>
               <h3>/student - получить всех студентов</h3>
               <h3>/student/search?name='studentName' - получить список студентов, \s
               чье имя содержит подстроку studentName</h3>
               <h3>/group/{groupName}/student - получить всех студентов группы</h3>
               <h3>/student - создать студента (принимает JSON)</h3>
               <h3>/student/{id} - удалить студента</h3>
                """;
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable long id) {
        return studentRepository.getById(id);
    }

    @GetMapping(path = "/student")
    public List<Student> getStudents() {
        return studentRepository.getAll();
    }

    @GetMapping(path = "/student/search?name='studentName'")
    public List<Student> getStudentsByName(@RequestParam(required = false) String name) {
        return studentRepository.getByName(name);
    }

    @GetMapping(path = "/group/{groupName}/student")
    public List<Student> getStudentsByGroup(@PathVariable String groupName) {
        return studentRepository.getByGroup(groupName);
    }

    @PostMapping(path = "/student")
    public Student createStudent(Student student) {
        studentRepository.addStudent(student);
        return student;
    }

    @DeleteMapping(path = "/student/{id}")
    public boolean deleteStudent(@PathVariable long id) {
        if (studentRepository.getById(id) == null) {
            throw new IllegalArgumentException();
        }
        studentRepository.deleteStudent(id);
        return true;

    }

}
