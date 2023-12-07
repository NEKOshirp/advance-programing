package org.example.entity;
import org.example.interfaces.Student;

public class ExcellentStudentDecorator extends StudentDecorator {
    public ExcellentStudentDecorator(Student decoratedStudent) {
        super(decoratedStudent);
    }

    public void study() {
        super.study();
        System.out.println("Excellent student is studying exceptionally well.");
    }

    @Override
    public int getId() {
        return 0;
    }
}
