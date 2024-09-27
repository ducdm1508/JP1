package Controller;

import Entity.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StudentController {

    private static List<Student> students;
    public StudentController(List<Student> students) {
        StudentController.students = students;
    }

    public Optional<Student> getYourngest(){
        Optional<Student> studentYourngest = students.stream()
                .min(Comparator.comparing(Student::getAge));
        return studentYourngest;
    }

    public static List<Student> getNameStudents(String keywork) {
        List<Student> getName = students.stream()
                .filter(student -> student.getName().toLowerCase().contains(keywork.toLowerCase()))
                .toList();
        return getName;
    }
}
