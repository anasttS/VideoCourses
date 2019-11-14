<%@ page import="models.Comment" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/js/swiper.jquery.min.js"></script>
    <script src="assets/js/Simple-Slider.js"></script>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

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
    <link href="https://fonts.googleapis.com/css?family=Atomic+Age|Monoton|Raleway:900&display=swap" rel="stylesheet">

</head>

<body>
<%@ include file="/jsp/navbar.jsp" %>
<div class="container-fluid">
    <div class="video-container">
        <div class="row">
            <div class="col-8">
                <div class="video">
                    <iframe allowfullscreen="" frameborder="0"
                            src="${video.url}" class=""></iframe>
                </div>
                <br>
                <div class="row video-info">
                    <div class="col">
                        <span><h2>${video.name}</h2></span>
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="col-md-6">
                        <span>${video.views} views | ${video.upload_date}</span>
                    </div>
                    <div class="col-md-6 d-flex flex-row-reverse align-items-center">
                        <form method="post" action="/video">
                            <input type="hidden" name="id" value="${video.id_video}">
                        <button type="submit" class="btn btn-primary btn-sm" name="like">Like</button>
                        </form>
                        <span class="likes-count">${video.likes} Likes</span>
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col-md-3">
                        <div class="small-channel-info d-flex d-lg-inline">
                            <img src="${imgOfChannel}" alt="channel logo" class="small-channel-image"
                                 style="width: 50px; height: 50px;">
                            <span>${nameOfChannel}</span>
                        </div>
                    </div>

                </div>
                <br>
                <div class="row">
                    <div class="video-description">
                        <span>${video.description}</span>
                    </div>
                </div>
                <hr>
                <h4>Comments</h4>
                <div class="form-group">
                    <form action="/video" method="post" class="d-flex d-flex">
                        <input type="text" name="text" class="form-control" placeholder="Write a comment"
                               style="margin-right: 10px;">
                        <input type="hidden" name="id" value="${video.id_video}">
                        <button type="submit" class="btn btn-primary" name="send" value="${video.id_video}">Send
                        </button>
                    </form>
                </div>
                <hr>
                <c:forEach var="comment" items="${comments}">
                    <div class="comment-card">
                        <div class="row">
                            <div class="col">
                                <span><h5><c:out value="${comment.userName}"/></h5></span>
                                <small><c:out value="${comment.date}"/></small>
                                <div class="col comment-text">
                                    <span><c:out value="${comment.text}"/></span>
                                </div>
                            </div>
                        </div>
                    </div>

                </c:forEach>
            </div>
            <div class="col-4" style="padding-left: 30px;">
                <form action="/video" method="post">
                    <div class="form-group"><textarea class="form-control"
                                                      style="width: 100%;height: 200px;margin-right: 20px;"
                                                      name="noteText"></textarea>
                        <input type="hidden" name="id" value="${video.id_video}">
                        <button name="save" class="btn btn-primary" type="submit" style="margin: 0px;margin-top: 20px;">
                            Save note
                        </button>
                    </div>
                </form>
                <hr>
            </div>


        </div>
    </div>
</div>
</div>
</div>
</div>
</body>

</html>