<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>


    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <script type="application/javascript"
            src="js/jquery-1.9.1.js"></script>

    <title>Videos</title>
</head>
<body>
<%@ include file="/jsp/navbar.jsp" %>


<form action="<c:url value="/videos"/>" method="get" id="searchForm" class="channel-header">
    <div class="input-group-btn search-panel">
        <select name="search_param" id="search_param" class="btn btn-default dropdown-toggle"
                data-toggle="dropdown" onfocus="">
            <option value="video">Video</option>
            <option value="username">Username</option>
            <option value="channelName">ChannelName</option>
        </select>
    </div>
    <input type="text" class="form-control mr-sm-2" name="x" id="query" oninput="f()"
           placeholder="Search term...">
    <%--<button class="btn btn-default" type="submit" name="search"> Search--%>
    <%--</button>--%>
</form>
<%--<%String t = "true";%>--%>
<%--<div id="b" value="false"></div>--%>
<script type="application/javascript">

    function f() {
        if ($("#query").val().length >= 1) {
            $.ajax({
                    url: "/doSearch",
                    data: {"query": $("#query").val(), "search_param": $("#search_param").val()},
                    dataType: "json",
                    success: function (msg) {
                        if (msg.videos.length > 0) {
                            // var t = document.getElementById("b");
                            // window.location.replace("videoPage.jsp?t="+t);
                            $("#res").html("");
                            for (var i = 0; i < msg.videos.length; i++) {
                                var o = msg.videos[i];
                                var id_video = o.id;
                                var img = o.img;
                                var name = o.name;
                                var description = o.description;

                                $("#res").append("<div class=\"channel-container\">\n" +
                                    "    <div class=\"card-container\">\n" +
                                    "        <div class=\"d-flex flex-wrap\"> <div class=\"card\" style=\"width: 18rem;\">\n" +
                                    "                    <img src=\"" + img + "\" class=\"card-img-top\" alt=\"...\">\n" +
                                    "                    <div class=\"card-body\">\n" +
                                    "                        <h5 class=\"card-title\">" + name + "</h5>\n" +
                                    "                        <p class=\"card-text\">" + description + "</p>\n" +
                                    "                        <form action=\"/video\" method=\"get\">\n" +
                                    "                            <button type=\"submit\" class=\"btn btn-primary\" value=\"" + id_video + "\" name=\"id\">\n" +
                                    "                                Watch video\n" +
                                    "                            </button>\n" +
                                    "                        </form>\n" +
                                    "                    </div>\n" +
                                    "                </div> </div> </div> </div>");
                            }
                        } else {
                            $("#res").html("No results..");
                        }
                    }
                }
            )
        } else {
            $("#res").html("");
        }
    }
</script>

<div id="res"></div>

<%--<% t = request.getParameter("t");--%>
<%--if (t.equals(true)) {%>--%>
<div class="features-clean">
    <div class="intro">
        <h2 class="text-center">All videos: </h2>
    </div>
</div>
<div class="channel-container">
    <div class="card-container">
        <div class="d-flex flex-wrap">
            <c:forEach var="video" items="${videos}">
                <!--Карточка-->
                <div class="card" style="width: 18rem;">
                    <img src="${video.img}" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">${video.name}</h5>
                        <p class="card-text">${video.description}</p>
                        <form action="/video" method="get">
                            <button type="submit" class="btn btn-primary" value="${video.id_video}" name="id">
                                Watch video
                            </button>
                        </form>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

</div>
</div>
<%--<%}%>--%>
<br>
<br>
<footer id="sticky-footer" class="py-4 bg-dark text-white-50">
    <div class="container text-center">
        <small>Copyright &copy; Video Courses</small>
    </div>
</footer>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/bootstrap.bundle.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/js/swiper.jquery.min.js"></script>
<script src="assets/js/Simple-Slider.js"></script>
</body>
</html>