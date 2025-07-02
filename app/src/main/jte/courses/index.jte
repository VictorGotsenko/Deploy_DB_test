@import database.example.util.NamedRoutes
@import database.example.dto.CoursesPage
@param CoursesPage page

@template.layout.page(
page = page,
content = @`
    <h1>All courses</h1>
    <div class="mb-3">
        <a href="${NamedRoutes.buildCoursePath()}">Add New Course</a>
    </div>
    @if(page.getCourses().isEmpty())
        <p>Пока не добавлено ни одного курса</p>
    @else
        @for(var course : page.getCourses())
            <div>
                <h2><a href="/courses/${course.getId()}">${course.getName()}</a></h2>
                <p>${course.getDescription()}</p>
            </div>
        @endfor
    @endif
`)