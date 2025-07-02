@import database.example.util.NamedRoutes
@param gg.jte.Content content
@param database.example.dto.BasePage page = null

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Анализатор страниц</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr"
          crossorigin="anonymous"
    >
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q"
        crossorigin="anonymous">
</script>
<main>
    <p>
        <a href="/">Main</a>
        <%--        <a href="${NamedRoutes.usersPath()}">Users</a>--%>
        <a href="${NamedRoutes.coursesPath()}">Courses</a>
    </p>
    @if(page != null && page.getFlash() != null)

        @if(page.getFlashType().equals("danger"))
            <div class="rounded-0 m-0 alert alert-dismissible fade show alert-danger" role="alert">
                <p class="m-0">${page.getFlash()}</p>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        @elseif(page.getFlashType().equals("success"))
            <div class="rounded-0 m-0 alert alert-dismissible fade show alert-success" role="alert">
                <p class="m-0">${page.getFlash()}</p>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        @endif
    @endif

    <div class="mx-auto p-4 py-md-5">
        ${content}
    </div>
</main>
</body>
</html>
