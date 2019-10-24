<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/bootstrap-grid.css" rel="stylesheet">
    <link href="css/bootstrap-reboot.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Atomic+Age|Monoton|Raleway:900&display=swap" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <title>Index</title>
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
        <ul class="navbar-nav ml-auto nav-flex-icons">
            <li class="nav-item">
                <a class="nav-link waves-effect waves-light">
                    <i class="fab fa-twitter"></i>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link waves-effect waves-light">
                    <i class="fab fa-google-plus-g"></i>
                </a>
            </li>
            <li class="nav-item">
                <a href="/login" class="nav-link text-white">Log-in</a>
            </li>
            <li class="nav-item">
                <a href="/logout" class="nav-link text-white">Log-out</a>
            </li>
        </ul>
    </div>
</nav>
<div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="bg1.jpg" class="d-block vw-100 vh-25" alt="...">
        </div>
        <div class="carousel-item">
            <img src="bg2.jpg" class="d-block vw-100 vh-50" alt="...">
        </div>
        <div class="carousel-item">
            <img src="bg3.jpg" class="d-block vw-100 vh-50" alt="...">
        </div>
    </div>
    <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>
<div class="container">
    <hr>
    <section class="my-5">
        <h2 class="h1-responsive font-weight-bold text-center my-5">Recent videos</h2>
        <div class="row">
            <div class="col-lg-5 col-xl-4">
                <div class="view overlay rounded z-depth-1-half mb-lg-0 mb-4">
                    <img class="img-fluid" src="https://mdbootstrap.com/img/Photos/Others/images/49.jpg"
                         alt="Sample image">
                    <a>
                        <div class="mask rgba-white-slight"></div>
                    </a>
                </div>
            </div>
            <div class="col-lg-7 col-xl-8">
                <h3 class="font-weight-bold mb-3"><strong>${videoName1}</strong></h3>
                <p class="dark-grey-text">${videoDescription1}</p>
                <p>by <a class="font-weight-bold">${author1}</a>, ${uploadDate1}</p>
                <a class="btn btn-primary btn-md">Watch video</a>
            </div>
        </div>
        <hr class="my-5">
        <div class="row">
            <div class="col-lg-5 col-xl-4">
                <div class="view overlay rounded z-depth-1-half mb-lg-0 mb-4">
                    <img class="img-fluid" src="https://mdbootstrap.com/img/Photos/Others/images/49.jpg"
                         alt="Sample image">
                    <a>
                        <div class="mask rgba-white-slight"></div>
                    </a>
                </div>
            </div>
            <div class="col-lg-7 col-xl-8">
                <h3 class="font-weight-bold mb-3"><strong>${videoName2}</strong></h3>
                <p class="dark-grey-text">${videoDescription2}</p>
                <p>by <a class="font-weight-bold">${author2}</a>, ${uploadDate2}</p>
                <a class="btn btn-primary btn-md">Watch video</a>
            </div>
        </div>
        <hr class="my-5">
        <div class="row">
            <div class="col-lg-5 col-xl-4">
                <div class="view overlay rounded z-depth-1-half mb-lg-0 mb-4">
                    <img class="img-fluid" src="https://mdbootstrap.com/img/Photos/Others/images/49.jpg"
                         alt="Sample image">
                    <a>
                        <div class="mask rgba-white-slight"></div>
                    </a>
                </div>
            </div>
            <div class="col-lg-7 col-xl-8">
                <h3 class="font-weight-bold mb-3"><strong>${videoName3}</strong></h3>
                <p class="dark-grey-text">${videoDescription3}</p>
                <p>by <a class="font-weight-bold">${author3}</a>, ${uploadDate3}</p>
                <a class="btn btn-primary btn-md">Watch video</a>
            </div>
        </div>
        <hr class="my-5">


    </section>
    <!-- Section: Blog v.3 -->
</div>
<br>
<br>
<footer id="sticky-footer" class="py-4 bg-dark text-white-50">
    <div class="container text-center">
        <small>Copyright &copy; Video Courses</small>
    </div>
</footer>
</body>
</html>