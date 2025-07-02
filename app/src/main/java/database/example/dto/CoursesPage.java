package database.example.dto;

import database.example.model.Course;


import java.util.List;

public class CoursesPage extends BasePage {
    private List<Course> courses;

    public CoursesPage(List<Course> courses) {
        super(null, null);
        this.courses = courses;
    }

    public final List<Course> getCourses() {
        return courses;
    }

}
