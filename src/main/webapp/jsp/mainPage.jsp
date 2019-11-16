<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<jsp:useBean id="username" scope="request" class="models.User">--%>
    <%--<jsp:setProperty name="username" property="*"/>--%>
<%--</jsp:useBean>--%>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/jsp/header.jsp" %>
    <title>Main</title>

</head>

<body background="assets/img/bg1.jpg">
<%@ include file="/jsp/navbar.jsp" %>
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
        </div>
        <!-- End: Intro -->
        <hr>
        <!-- Start: Features -->
        <div class="row features">
            <div class="col-sm-6 col-lg-4 item"><i class="fa fa-group icon"></i>
                <h3 class="name">Good users</h3>
                <p class="description">There is you can find a lot of information, and if you don’t understand something, you can ask someone in chat.</p>
            </div>
            <div class="col-sm-6 col-lg-4 item"><i class="fa fa-clock-o icon"></i>
                <h3 class="name">Always available</h3>
                <p class="description">You can use it 24/7.</p>
            </div>
            <div class="col-sm-6 col-lg-4 item"><i class="fa fa-gift icon"></i>
                <h3 class="name">Free</h3>
                <p class="description">All videos and features are available to any registered user. </p>
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
                        <h3 class="name">Easy math</h3>
                        <p class="description">Informative course about math.</p>
                    </div>
                </div>
            </div>
            <div class="col-sm-6 item">
                <div class="row">
                    <div class="col-md-12 col-lg-5"><a href="#"><img class="img-fluid"
                                                                     src="assets/img/building.jpg"></a></div>
                    <div class="col">
                        <h3 class="name">Playing the guitar</h3>
                        <p class="description">Video tutorials</p>
                    </div>
                </div>
            </div>
            <div class="col-sm-6 item">
                <div class="row">
                    <div class="col-md-12 col-lg-5"><a href="#"><img class="img-fluid" src="assets/img/loft.jpg"></a>
                    </div>
                    <div class="col">
                        <h3 class="name">English Grammar </h3>
                        <p class="description">All rules of english language</p>
                    </div>
                </div>
            </div>
            <div class="col-sm-6 item">
                <div class="row">
                    <div class="col-md-12 col-lg-5"><a href="#"><img class="img-fluid"
                                                                     src="assets/img/minibus.jpeg"></a></div>
                    <div class="col">
                        <h3 class="name">Web programming</h3>
                        <p class="description">Html + css + js</p>
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
                        <li><a href="#">Team</a></li>
                    </ul>
                </div>
                <!-- End: About -->
                <!-- Start: Footer Text -->
                <div class="col-md-6 item text">
                    <h3>Lectio</h3>
                    <p>Educational video platform
                    </p>
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