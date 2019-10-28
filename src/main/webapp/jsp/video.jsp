<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Lectio (Backup 1571973011891)</title>
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/bootstrap-grid.css" rel="stylesheet">
    <link href="css/bootstrap-reboot.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Aclonica">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Aldrich">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Alfa+Slab+One">
    <link rel="stylesheet" href="css/Features-Clean.css">
    <link rel="stylesheet" href="css/Footer-Dark.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/css/swiper.min.css">
    <link rel="stylesheet" href="css/Projects-Horizontal.css">
    <link rel="stylesheet" href="css/Simple-Slider.css">
    <link rel="stylesheet" href="css/styles.css">

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>

    <link href="https://fonts.googleapis.com/css?family=Atomic+Age|Monoton|Raleway:900&display=swap" rel="stylesheet">

</head>

<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand logo" href="/main">Lectio</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-333"
            aria-controls="navbarSupportedContent-333" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent-333">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link text-white" href="#">Home
                    <span class="sr-only">(current)</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-white" href="#">Features</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-white" href="#">Pricing</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle text-white" id="navbarDropdownMenuLink-3333" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">Dropdown
                </a>
                <div class="dropdown-menu dropdown-default" aria-labelledby="navbarDropdownMenuLink-3333">
                    <a class="dropdown-item" href="#">Action</a>
                    <a class="dropdown-item" href="#">Another action</a>
                    <a class="dropdown-item" href="#">Something else here</a>
                </div>
            </li>
        </ul>
        <ul class="navbar-nav ml-auto">
            <% session = request.getSession();
                if ( session != null) { %>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle text-white" id="profile" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    ${username}
                </a>
                <div class="dropdown-menu dropdown-menu-right dropdown-default"
                     aria-labelledby="profile">
                    <a class="dropdown-item" href="/profile">Profile</a>
                    <a class="dropdown-item" href="/notes">My notes</a>
                    <a class="dropdown-item" href="/logout">Logout</a>
                </div>
            </li>
            <%--<% } else { %>--%>
            <%--<ul class="navbar-nav ml-auto nav-flex-icons">--%>
                <%--<li class="nav-item">--%>
                    <%--<a href="/login" class="nav-link text-white">Login</a>--%>
                <%--</li>--%>
                <%--<li class="nav-item">--%>
                    <%--<a href="/register" class="nav-link text-white">Register</a>--%>
                <%--</li>--%>
            <%--</ul>--%>
            <%--<% } %>--%>
        </ul>
    </div>
</nav>
<div class="container-fluid">
    <div class="video">
        <div class="row" style="margin: 0px;">
            <div class="col-8">
                <div class="">
                    <iframe allowfullscreen="" frameborder="0" width="853" height="480"
                            src="https://www.youtube.com/embed/rRaUSpBL004"></iframe>
                </div>
            </div>
            <div class="col-4" style="padding-left: 30px;">
                <form action="/">
                    <div class="form-group"><textarea class="form-control"
                                                      style="width: 100%;height: 200px;margin-right: 20px;"
                                                      name="noteText"></textarea>
                        <button class="btn btn-primary" type="submit" name="saveNote" style="margin: 0px;margin-top: 20px;">Button
                        </button>
                    </div>
                </form>
                <hr>
                <div>
                    <div class="card">
                        <div class="card-body" style="padding: 5px;">
                            <div class="row" style="margin: 0px;">
                                <div class="col" style="width: 192px;height: 109px;padding: 0px;"></div>
                                <div class="col">
                                    <div>
                                        <h4>Title</h4>
                                        <p>Nullam id dolor id nibh ultricies vehicula ut id elit. Cras justo odio,
                                            dapibus ac facilisis&nbsp;</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>s
        </div>
    </div>
</div>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/js/swiper.jquery.min.js"></script>
<script src="assets/js/Simple-Slider.js"></script>
</body>

</html>