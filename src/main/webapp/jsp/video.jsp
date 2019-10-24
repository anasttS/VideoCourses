<%--
  Created by IntelliJ IDEA.
  User: smysh
  Date: 11.10.2019
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="../css/bootstrap.css" rel="stylesheet">
    <link href="../css/bootstrap-grid.css" rel="stylesheet">
    <link href="../css/bootstrap-reboot.css" rel="stylesheet">
    <link href="../css/style.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <title>Video</title>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-dark text-white">
    <a class="navbar-brand text-white" href="/main2">Navbar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown"
            aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">

            <li class="nav-item active">
                <a class="nav-link text-white" href="#">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-white" href="#">Features</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-white" href="#">Pricing</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle text-white" href="#" id="navbarDropdownMenuLink" role="button"
                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Dropdown link
                </a>
                <div class="dropdown-menu bg-dark" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item text-white" href="#">Action</a>
                    <a class="dropdown-item text-white" href="#">Another action</a>
                    <a class="dropdown-item text-white" href="#">Something else here</a>
                </div>
            </li>
        </ul>
    </div>
</nav>
<br>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-8">
            <div class="embed-responsive embed-responsive-16by9">
                <iframe class="embed-responsive-item video" src="https://www.youtube.com/embed/pfOwPMqHv90"
                        allowfullscreen></iframe>
            </div>
        </div>
        <div class="col">
            <form action="video" method="post">
                <div class="form-group">
                    <span><h4>Note</h4></span>
                    <textarea class="form-control note-field" id="exampleFormControlTextarea1" rows="10" name="note"></textarea>
                </div>
                <input type="submit" class="btn btn-primary btn-sm" name="save" />
            </form>
            <hr>
            <div class="small-video-card">
                <div class="row">
                    <div class="col-md-8">
                        <img src="1.jpg" alt="" class="card-img-left">
                    </div>
                    <div class="col">
                        <h5>Video name</h5>
                        <span>Author</span>
                        <br>
                        <span>Likes: 100</span>
                        <br>
                        <span>Topic</span>
                    </div>
                </div>
            </div>
            <hr>
            <div class="small-video-card">
                <div class="row">
                    <div class="col-md-8">
                        <img src="1.jpg" alt="" class="card-img-left">
                    </div>
                    <div class="col">
                        <h5>Video name</h5>
                        <span>Author</span>
                        <br>
                        <span>Likes: 100</span>
                        <br>
                        <span>Topic</span>
                    </div>
                </div>
            </div>
            <br>
            <div class="small-video-card">
                <div class="row">
                    <div class="col-md-8">
                        <img src="1.jpg" alt="" class="card-img-left">
                    </div>
                    <div class="col">
                        <h5>Video name</h5>
                        <span>Author</span>
                        <br>
                        <span>Likes: 100</span>
                        <br>
                        <span>Topic</span>
                    </div>
                </div>
            </div>
            <br>
            <div class="small-video-card">
                <div class="row">
                    <div class="col-md-8">
                        <img src="1.jpg" alt="" class="card-img-left">
                    </div>
                    <div class="col">
                        <h5>Video name</h5>
                        <span>Author</span>
                        <br>
                        <span>Likes: 100</span>
                        <br>
                        <span>Topic</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <br>
</div>


<br>
<footer id="sticky-footer" class="py-4 bg-dark text-white-50">
    <div class="container text-center">
        <small>Copyright &copy; Video Courses</small>
    </div>
</footer>
</body>
</html>