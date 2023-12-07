package org.example.service;
import java.util.HashMap;
import org.example.entity.Student;
import java.util.Map;
public class StudentFlyweightFactory {
    private static final Map<String, Student> studentMap = new HashMap<>();

    public static Student createStudent(int id, String name) {
        String key = id + "-" + name;

        if (!studentMap.containsKey(key)) {
            studentMap.put(key, new Student(id, name));
        }

        return studentMap.get(key);
    }
}
