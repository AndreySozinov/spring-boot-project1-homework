package ru.savrey.springbootproject1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.savrey.springbootproject1.homework.Student;
import ru.savrey.springbootproject1.homework.StudentRepository;

@SpringBootApplication
public class SpringBootProject1Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootProject1Application.class, args);

		StudentRepository studentRepository = context.getBean(StudentRepository.class);

		studentRepository.addStudent(new Student("Johnas", "First"));
		studentRepository.addStudent(new Student("Smyth", "Second"));
		studentRepository.addStudent(new Student("Pollio", "Third"));
		studentRepository.addStudent(new Student("Smirnoff", "First"));
		studentRepository.addStudent(new Student("Jameson", "First"));
		studentRepository.addStudent(new Student("Walker", "Third"));
		studentRepository.addStudent(new Student("Riddik", "Second"));
		studentRepository.addStudent(new Student("Kenobi", "Second"));
		studentRepository.addStudent(new Student("Clover", "First"));
		studentRepository.addStudent(new Student("Godspeed", "First"));
	}

}
