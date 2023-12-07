package org.example.interfaces;

import org.example.entity.Student;

import java.util.List;

public interface StudentInterface {
    public Student insert(Student s);
    public Student update(Student s);
    public  boolean delete(int id);
    public List<Student> findAll();
    public Student findById(int id);

}

