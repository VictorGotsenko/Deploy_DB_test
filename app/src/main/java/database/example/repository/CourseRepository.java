package database.example.repository;

import database.example.model.Course;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CourseRepository extends BaseRepository {
    public static void save(Course course) throws SQLException {
        String sql = "INSERT INTO courses (name, description) VALUES (?, ?)";
        try (var conn = dataSource.getConnection();
             var preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, course.getName());
            preparedStatement.setString(2, course.getDescription());
            preparedStatement.executeUpdate();
            var generatedKeys = preparedStatement.getGeneratedKeys();
            // Устанавливаем ID в сохраненную сущность
            if (generatedKeys.next()) {
                course.setId(generatedKeys.getLong(1));
            } else {
                throw new SQLException("DB have not returned an id after saving an entity");
            }
        }
    }

    public static Optional<Course> find(Long id) throws SQLException {
        var sql = "SELECT * FROM courses WHERE id = ?";
        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            var resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                Course course = new Course(name, description);
                course.setId(id);
                return Optional.of(course);
            }
            return Optional.empty();
        }
    }

    public static List<Course> getEntities() throws SQLException {
        var sql = "SELECT * FROM courses";
        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            var resultSet = stmt.executeQuery();
            List<Course> entitiesCourses = new ArrayList<Course>();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                Course course = new Course(name, description);
                course.setId(id);
                entitiesCourses.add(course);
            }
            return entitiesCourses;
        }
    }

}
