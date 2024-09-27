import Controller.StaffController;
import Controller.StudentController;
import Entity.Gender;
import Entity.Staff;
import Entity.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students  = new ArrayList<>();
        List<Staff> staffs  = new ArrayList<>();
        students.add(new Student("C2309G5953", "Hai", LocalDate.of(2005, 05, 24), Gender.M, "Ha Noi"));
        students.add(new Student("C2309G5975", "Vinh", LocalDate.of(2006, 11, 11), Gender.M, "Ha Noi"));
        students.add(new Student("C2309G5955", "Hieu Hoang", LocalDate.of(1999, 11, 11), Gender.F, "Ha Noi"));

        staffs.add(new Staff("ST1001", "Toan", "Aptech", Gender.M, 10000, "Ha Noi"));
        staffs.add(new Staff("ST1002", "Tinh", "Aptech", Gender.F, 20000, "Ha Noi"));
        staffs.add(new Staff("ST1003", "Le", "Aptech", Gender.F, 13000, "Ha Noi"));
        staffs.add(new Staff("ST1004", "Tuan", "Aptech", Gender.M, 14000, "Ha Noi"));
        staffs.add(new Staff("ST1005", "Hung", "Aptech", Gender.M, 16000, "Ha Noi"));

        staffs.forEach(System.out::println);
//        StudentController sc = new StudentController(students);
//        Optional<Student> studentYoungest = sc.getYourngest();
//        System.out.println(studentYoungest);
//
//        System.out.println("nhap ten: ");
//        String search = scanner.nextLine();
//        StudentController.getNameStudents(search).forEach(System.out::println);

        StaffController st = new StaffController(staffs);
        Optional<Staff> femaleByPay = st.getFByPay();
        System.out.println(femaleByPay);

        System.out.println("nhap ten or id: ");
        String search = scanner.nextLine();
        StaffController.getStaffsById(search).forEach(System.out::println);
        StaffController.getStaffsByName(search).forEach(System.out::println);

        System.out.println("nhap id : ");
        String id = scanner.nextLine();
        System.out.println("nhap ten muon doi : ");
        String newName = scanner.nextLine();
        StaffController.changeName(id, newName);

        staffs.forEach(System.out::println);
    }
}