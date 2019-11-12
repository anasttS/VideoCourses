<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
    <title>Channel</title>
</head>
<body>
<%@ include file="/jsp/navbar.jsp" %>
<div class="channel-container">
    <div class="channel-header">
        <div class="channel-header-image">
            <img src="${img}" alt="img" class="img-thumbnail2" width="120px" height="120px">
        </div>
        <div class="channel-header-description">
            <h2>${nameOfChannel}</h2>
            <span>${channelDescription}</span>
            <div class="fa-align-right">
                <form method="post" action="/channelProfile">
                    <button class="btn-sm btn-primary" name="redirect" type="submit">Add Video</button>
                </form>
            </div>
        </div>
    </div>
    <div class="container-fluid">
        <div class="row">
            <c:forEach var="video" items="${videos}">
                <div class="card-container">
                    <div class="d-flex flex-wrap">

                        <!--Карточка-->
                        <div class="card" style="width: 18rem;">
                            <img src="${video.img}" class="card-img-top" alt="...">
                            <div class="card-body" style="height: 185px;">
                                <h5 class="card-title">${video.name}</h5>
                                <p class="card-text">${video.description}</p>
                                <form action="/video" method="get">
                                    <button type="submit" class="btn btn-primary" value="${video.id_video}" name="id">
                                        Watch
                                        video
                                    </button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
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