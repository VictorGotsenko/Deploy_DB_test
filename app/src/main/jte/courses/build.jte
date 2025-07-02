@import database.example.util.NamedRoutes
@param database.example.dto.BuildCoursePage page

@template.layout.page(
page = page,
content = @`
    @if(page.getErrors() != null)
        <div class="mb-3">
            <ul>
                @for(var validator : page.getErrors().values())
                    @for(var error : validator)
                        <li>${error.getMessage()}</li>
                    @endfor
                @endfor
            </ul>
        </div>
    @endif
    <div class="mx-auto p-4 py-md-5">
        <form action="${NamedRoutes.coursesPath()}" method="post">
            <div class="mb-3">
                <label class="form-label">
                    Название
                    <input type="text" class="form-control" required name="name" value="${page.getName()}"/>
                </label>
            </div>
            <div class="mb-3">
                <label class="form-label">
                    Описание
                    <input type="text" class="form-control" required name="description"
                           value="${page.getDescription()}"/>
                </label>
            </div>
            <input type="submit" class="btn btn-primary" value="Создать"/>
        </form>
    </div>
`)