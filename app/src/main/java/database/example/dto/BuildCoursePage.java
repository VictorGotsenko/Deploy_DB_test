package database.example.dto;

import java.util.List;
import java.util.Map;

import io.javalin.validation.ValidationError;

public final class BuildCoursePage extends BasePage {
    private String name;
    private String description;
    private Map<String, List<ValidationError<Object>>> errors;


    public BuildCoursePage() {
        super(null, null);
    }

    public BuildCoursePage(String name, String description, Map<String, List<ValidationError<Object>>> errors) {
        super(null, null);
        this.name = name;
        this.description = description;
        this.errors = errors;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, List<ValidationError<Object>>> getErrors() {
        return errors;
    }

    public void setFlashAndType(String flash, String flashType) {
        super.setFlash(flash);
        super.setFlashType(flashType);
    }
}
