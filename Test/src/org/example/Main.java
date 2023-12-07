package org.example;

import org.example.entity.*;
import org.example.interfaces.NotifyInterface;
import org.example.interfaces.UpdateInfoRequest;
import org.example.service.AccountFactory;
import org.example.service.AdminService;
import org.example.service.FacadeService;
import org.example.service.TeacherService;
import org.example.service.StudentFlyweightFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Insert teacher =========Singleton - Creation======================================
        Teacher teacher = new Teacher(1, "Dinh Van Dong");
        TeacherService.getInstance().insert(teacher);

        // Iterator ============Behavior ====================================================
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "An"));
        studentList.add(new Student(2, "Binh"));
        studentList.add(new Student(3, "Nam"));

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("==============================");
            System.out.println("1. Hiển thị danh sách sinh viên");
            System.out.println("2. Tìm kiếm sinh viên");
            System.out.println("3. Thoát");
            System.out.println("==============================");
            System.out.print(": ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayStudentList(studentList);
                    break;
                case 2:
                    searchStudent(studentList);
                    break;
                case 3:
                    System.out.println("Kết thúc.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 3);

        //===================================================================================
        // Adapter ========Structural Pattern
        UpdateInfoRequest updateInfoRequest = new AdminService(TeacherService.getInstance());
        updateInfoRequest.updateInfoTeacher(teacher);

        //===================================================================================
        // Factory Method == Creational Pattern
        NotifyInterface notifyStudent = AccountFactory.createNotification("Student");
        notifyStudent.notification();

        NotifyInterface notifyTeacher = AccountFactory.createNotification("Teacher");
        notifyTeacher.notification();

        NotifyInterface notifyParent = AccountFactory.createNotification("Parent");
        notifyParent.notification();
        //=========================================================================

        //Facade == Structural Pattern
        FacadeService facadeService = new FacadeService();
        facadeService.operationDeleteTeacher(1);

        // Flyweight == Structural Pattern
        Student student1 = StudentFlyweightFactory.createStudent(1, "An");
        Student student2 = StudentFlyweightFactory.createStudent(1, "An");
        //proxy
        System.out.println("Student 1: " + student1);
        System.out.println("Student 2: " + student2);
        System.out.println("Are they the same object? " + (student1 == student2));

        // Decorator == Structural Pattern
        BasicStudent basicStudent = new BasicStudent();
        basicStudent.study();

        System.out.println("=====");

        GoodStudentDecorator goodStudent = new GoodStudentDecorator(new BasicStudent());
        goodStudent.study();

        System.out.println("=====");

        ExcellentStudentDecorator excellentStudent = new ExcellentStudentDecorator(new GoodStudentDecorator(new BasicStudent()));
        excellentStudent.study();
    }

    private static void displayStudentList(List<Student> studentList) {
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            System.out.println("ID: " + student.getId());
            System.out.println("Name: " + student.getName());
            System.out.println("------------------------");
        }
    }
    private static void searchStudent(List<Student> studentList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập ID sinh viên: ");
        int id = scanner.nextInt();

        // Sử dụng Proxy để tìm kiếm sinh viên
        StudentSearch studentSearchProxy = new StudentSearchProxy(studentList);
        Student student = studentSearchProxy.findStudentById(id);

        if (student != null) {
            System.out.println("Sinh viên đã tìm thấy:");
            System.out.println("ID: " + student.getId());
            System.out.println("Name: " + student.getName());
        } else {
            System.out.println("Không tìm thấy sinh viên với ID " + id);
        }
    }
}