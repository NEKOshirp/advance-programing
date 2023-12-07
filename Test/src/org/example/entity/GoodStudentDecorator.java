package org.example.entity;

import org.example.interfaces.Student;

public class GoodStudentDecorator extends StudentDecorator {
    public GoodStudentDecorator(Student decoratedStudent) {
        super(decoratedStudent);
    }

    public void study() {
        super.study();
        System.out.println("Good student is studying hard.");
    }

    @Override
    public int getId() {
        return 0;
    }
}
