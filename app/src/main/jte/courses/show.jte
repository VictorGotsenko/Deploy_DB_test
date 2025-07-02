@import database.example.dto.CoursePage
@param CoursePage page

@template.layout.page(
content = @`
    <div class="mb-3">
        <h1>${page.getCourse().getName()}</h1>
        <p>${page.getCourse().getDescription()}</p>
    </div>
`,
)