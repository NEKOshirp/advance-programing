package org.example.service;
import org.example.interfaces.StudentInterface;
import org.example.entity.Student;

import java.util.List;

public class StudentProxy implements StudentInterface {
    private int id;
    private String name;
    private Student realStudent;

    public StudentProxy(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        if (realStudent == null) {
            realStudent = new Student(id, name);
        }
        return realStudent.getId();
    }

    public String getName() {
        if (realStudent == null) {
            realStudent = new Student(id, name);
        }
        return realStudent.getName();
    }
    @Override
    public Student insert(Student s) {
        return null;
    }

    @Override
    public Student update(Student s) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public Student findById(int id) {
        return null;
    }
}
