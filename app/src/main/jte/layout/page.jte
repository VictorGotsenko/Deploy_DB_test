@import database.example.util.NamedRoutes
@import database.example.dto.BasePage
@param gg.jte.Content content
@param BasePage page = null

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Database example</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<main>
    <p>
        <a href="/">Main</a>
        <%--        <a href="${NamedRoutes.usersPath()}">Users</a>--%>
        <a href="${NamedRoutes.coursesPath()}">Courses</a>
    </p>
    @if(page != null && page.getFlash() != null)
        <div class="alert alert-${page.getFlashType()}" role="alert">
            ${page.getFlash()}
        </div>
    @endif
    <div class="mx-auto p-4 py-md-5">
        ${content}
    </div>
</main>
</body>
</html>
