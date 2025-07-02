package database.example.util;

public class NamedRoutes {

    // Courses
    public static String rootPath() {
        return "/";
    }

    public static String coursesPath() {
        return "/courses";
    }

    public static String buildCoursePath() {
        return "/courses/build";
    }

    // Это нужно, чтобы не преобразовывать типы снаружи
    public static String coursePath(Long id) {
        return coursePath(String.valueOf(id));
    }

    public static String coursePath(String id) {
        return "/courses/" + id;
    }

}
