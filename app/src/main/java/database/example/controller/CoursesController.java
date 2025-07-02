package database.example.controller;

import database.example.model.Course;
import database.example.dto.CoursePage;
import database.example.dto.CoursesPage;
import database.example.util.NamedRoutes;
import database.example.dto.BuildCoursePage;
import database.example.repository.CourseRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import io.javalin.validation.ValidationException;

import java.sql.SQLException;

import static io.javalin.rendering.template.TemplateUtil.model;

public class CoursesController {
    public static void build(Context ctx) {
        var page = new BuildCoursePage();
        ctx.render("courses/build.jte", model("page", page));
    }

    public static void create(Context ctx) throws SQLException {
        try {
            var nameCourse = ctx.formParamAsClass("name", String.class)
                    .check(value -> value.length() > 2, "У названия недостаточная длина")
                    .get();
            var description = ctx.formParamAsClass("description", String.class)
                    .check(value -> value.length() > 10, "У описания недостаточная длина")
                    .get();

            var course = new Course(nameCourse, description);
            CourseRepository.save(course);
            // Добавляем сообщение в сессию
            // Ключ может иметь любое название, здесь мы выбрали flash
            ctx.sessionAttribute("flash", "Course created!");
            ctx.sessionAttribute("flash-type", "success");
            ctx.redirect(NamedRoutes.coursesPath());
//                ctx.redirect("/courses");
        } catch (ValidationException e) {
//            var page = new BuildCoursePage(e.getErrors());
            var page = new BuildCoursePage(ctx.formParam("name"), ctx.formParam("description"), e.getErrors());
            // set cookies
            ctx.sessionAttribute("flash", "Course not created!");
            ctx.sessionAttribute("flash-type", "danger");
            // read cookies
            page.setFlashAndType(ctx.consumeSessionAttribute("flash"), ctx.consumeSessionAttribute("flash-type"));
//            page.setFlashType(ctx.consumeSessionAttribute("flash-type"));
            ctx.render("courses/build.jte", model("page", page));
        }
    }

     // Courses
    public static void index(Context ctx) throws SQLException {
        var courses = CourseRepository.getEntities();
        CoursesPage page = new CoursesPage(courses);
        // read cookies
        page.setFlash(ctx.consumeSessionAttribute("flash"));
        page.setFlashType(ctx.consumeSessionAttribute("flash-type"));
        ctx.render("courses/index.jte", model("page", page));
    }

    public static void show(Context ctx) throws SQLException {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var course = CourseRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
        var page = new CoursePage(course);
        ctx.render("courses/show.jte", model("page", page));
    }


}
