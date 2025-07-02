package database.example.dto;

import database.example.model.Course;

public class CoursePage {
    private Course course;

    public CoursePage(Course course) {
        this.course = course;
    }

    public final Course getCourse() {
        return course;
    }
}
