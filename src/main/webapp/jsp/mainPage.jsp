<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<jsp:useBean id="username" scope="request" class="models.User">--%>
    <%--<jsp:setProperty name="username" property="*"/>--%>
<%--</jsp:useBean>--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Lectio</title>
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

<body background="assets/img/bg1.jpg">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand logo" href="<c:url value="/main"/>">Lectio</a>
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

        <c:if test="${auth != null}">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle text-white" id="main" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                        ${username}
                </a>
                <div class="dropdown-menu dropdown-menu-right dropdown-default"
                     aria-labelledby="main">
                    <a class="dropdown-item" href="<c:url value="/profile"/>">Profile</a>
                    <a class="dropdown-item" href="<c:url value="/notes"/>">My notes</a>
                    <a class="dropdown-item" href="<c:url value="/logout"/>">Logout</a>
                </div>
            </li>
        </c:if>
        <c:if test="${auth == null}">
            <ul class="navbar-nav ml-auto nav-flex-icons">
                <li class="nav-item">
                    <a href="<c:url value="/login"/>" class="nav-link text-white">Login</a>
                </li>
                <li class="nav-item">
                    <a href="<c:url value="/register"/>" class="nav-link text-white">Register</a>
                </li>
            </ul>
        </c:if>
    </div>
</nav>
<!-- Start: Simple Slider -->
<div class="simple-slider">
    <!-- Start: Slideshow -->
    <div class="swiper-container">
        <!-- Start: Slide Wrapper -->
        <div class="swiper-wrapper">
            <!-- Start: Slide -->
            <div class="swiper-slide" style="background-image:url(/assets/img/bg1.jpg);"></div>
            <!-- End: Slide -->
            <!-- Start: Slide -->
            <div class="swiper-slide" style="background-image:url(/assets/img/bg2.jpg);"></div>
            <!-- End: Slide -->
            <!-- Start: Slide -->
            <div class="swiper-slide" style="background-image:url(/assets/img/bg3.jpg);"></div>
            <!-- End: Slide -->
        </div>
        <!-- End: Slide Wrapper -->
        <!-- Start: Pagination -->
        <div class="swiper-pagination"></div>
        <!-- End: Pagination -->
        <!-- Start: Previous -->
        <div class="swiper-button-prev"></div>
        <!-- End: Previous -->
        <!-- Start: Next -->
        <div class="swiper-button-next"></div>
        <!-- End: Next -->
    </div>
    <!-- End: Slideshow -->
</div>
<!-- End: Simple Slider -->
<!-- Start: Features Clean -->
<div class="features-clean">
    <div class="container">
        <!-- Start: Intro -->
        <div class="intro">
            <h2 class="text-center">Why our project is good</h2>
            <p class="text-center">Nunc luctus in metus eget fringilla. Aliquam sed justo ligula. Vestibulum nibh erat,
                pellentesque ut laoreet vitae. </p>
        </div>
        <!-- End: Intro -->
        <hr>
        <!-- Start: Features -->
        <div class="row features">
            <div class="col-sm-6 col-lg-4 item"><i class="fa fa-group icon"></i>
                <h3 class="name">Good users</h3>
                <p class="description">Aenean tortor est, vulputate quis leo in, vehicula rhoncus lacus. Praesent
                    aliquam in tellus eu gravida. Aliquam varius finibus est.</p>
            </div>
            <div class="col-sm-6 col-lg-4 item"><i class="fa fa-clock-o icon"></i>
                <h3 class="name">Always available</h3>
                <p class="description">Aenean tortor est, vulputate quis leo in, vehicula rhoncus lacus. Praesent
                    aliquam in tellus eu gravida. Aliquam varius finibus est.</p>
            </div>
            <div class="col-sm-6 col-lg-4 item"><i class="fa fa-gift icon"></i>
                <h3 class="name">Free</h3>
                <p class="description">Aenean tortor est, vulputate quis leo in, vehicula rhoncus lacus. Praesent
                    aliquam in tellus eu gravida. Aliquam varius finibus est.</p>
            </div>
        </div>
        <!-- End: Features -->
    </div>
</div>
<!-- End: Features Clean -->
<!-- Start: Projects Horizontal -->
<div class="projects-horizontal">
    <div class="container">
        <!-- Start: Intro -->
        <div class="intro">
            <h2 class="text-center">Recent videos</h2>
        </div>
        <!-- End: Intro -->
        <hr>
        <!-- Start: Projects -->
        <div class="row projects">
            <div class="col-sm-6 item">
                <div class="row">
                    <div class="col-md-12 col-lg-5"><a href="#"><img class="img-fluid" src="assets/img/desk.jpg"></a>
                    </div>
                    <div class="col">
                        <h3 class="name">Project Name</h3>
                        <p class="description">Aenean tortor est, vulputate quis leo in, vehicula rhoncus lacus.
                            Praesent aliquam in tellus eu gravida.</p>
                    </div>
                </div>
            </div>
            <div class="col-sm-6 item">
                <div class="row">
                    <div class="col-md-12 col-lg-5"><a href="#"><img class="img-fluid"
                                                                     src="assets/img/building.jpg"></a></div>
                    <div class="col">
                        <h3 class="name">Project Name</h3>
                        <p class="description">Aenean tortor est, vulputate quis leo in, vehicula rhoncus lacus.
                            Praesent aliquam in tellus eu gravida.</p>
                    </div>
                </div>
            </div>
            <div class="col-sm-6 item">
                <div class="row">
                    <div class="col-md-12 col-lg-5"><a href="#"><img class="img-fluid" src="assets/img/loft.jpg"></a>
                    </div>
                    <div class="col">
                        <h3 class="name">Project Name</h3>
                        <p class="description">Aenean tortor est, vulputate quis leo in, vehicula rhoncus lacus.
                            Praesent aliquam in tellus eu gravida.</p>
                    </div>
                </div>
            </div>
            <div class="col-sm-6 item">
                <div class="row">
                    <div class="col-md-12 col-lg-5"><a href="#"><img class="img-fluid"
                                                                     src="assets/img/minibus.jpeg"></a></div>
                    <div class="col">
                        <h3 class="name">Project Name</h3>
                        <p class="description">Aenean tortor est, vulputate quis leo in, vehicula rhoncus lacus.
                            Praesent aliquam in tellus eu gravida.</p>
                    </div>
                </div>
            </div>
        </div>
        <!-- End: Projects -->
    </div>
</div>
<!-- End: Projects Horizontal -->
<!-- Start: Footer Dark -->
<div class="footer-dark">
    <footer>
        <div class="container">
            <div class="row">
                <!-- Start: About -->
                <div class="col-sm-6 col-md-3 item">
                    <h3>About</h3>
                    <ul>
                        <li><a href="#">Company</a></li>
                        <li><a href="#">Team</a></li>
                        <li><a href="#">Careers</a></li>
                    </ul>
                </div>
                <!-- End: About -->
                <!-- Start: Footer Text -->
                <div class="col-md-6 item text">
                    <h3>Lectio</h3>
                    <p>Praesent sed lobortis mi. Suspendisse vel placerat ligula. Vivamus ac sem lacus. Ut vehicula
                        rhoncus elementum. Etiam quis tristique lectus. Aliquam in arcu eget velit pulvinar dictum vel
                        in justo.</p>
                </div>
                <!-- End: Footer Text -->
                <!-- Start: Social Icons -->
                <div class="col item social"><a href="#"><i class="icon ion-social-facebook"></i></a><a href="#"><i
                        class="icon ion-social-twitter"></i></a><a href="#"><i class="icon ion-social-snapchat"></i></a><a
                        href="#"><i class="icon ion-social-instagram"></i></a></div>
                <!-- End: Social Icons -->
            </div>
            <!-- Start: Copyright -->
            <p class="copyright">Lectio © 2017</p>
            <!-- End: Copyright -->
        </div>
    </footer>
</div>
<!-- End: Footer Dark -->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/bootstrap.js"></script>
<script src="assets/js/bootstrap.bundle.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/js/swiper.jquery.min.js"></script>
<script src="assets/js/Simple-Slider.js"></script>
</body>

</html>