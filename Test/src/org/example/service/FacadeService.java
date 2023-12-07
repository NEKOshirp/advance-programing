package org.example.service;

import org.example.entity.Course;
import org.example.entity.Teacher;

public class FacadeService {
    private CourseService courseService;
    private TeacherService teacherService;

    public FacadeService() {
        courseService = new CourseService();
        teacherService = new TeacherService();
    }
    public void operationDeleteTeacher(int teacherId) {
        courseService.deleteByTeacherID(teacherId);
        teacherService.delete(teacherId);
    }

}
