package org.example.entity;
import org.example.interfaces.Student;

public class BasicStudent implements Student {
        public void study() {
            System.out.println("Basic student is studying.");
        }
}
abstract class StudentDecorator implements Student {
    protected Student decoratedStudent;

    public StudentDecorator(Student decoratedStudent) {
        this.decoratedStudent = decoratedStudent;
    }

    public void study() {
        decoratedStudent.study();
    }
}

