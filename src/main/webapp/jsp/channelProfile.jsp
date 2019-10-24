<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/bootstrap-grid.css" rel="stylesheet">
    <link href="css/bootstrap-reboot.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
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

<nav class="navbar navbar-expand-lg navbar-light bg-dark">
    <a class="navbar-brand text-white" href="/main2">Navbar</a>
</nav>
<div class="container-fluid">
    <br>
    <br>
    <diw class="row">
        <div class="col"></div>
        <div class="col-md-3" align="center">
            <span><h1>Channel Profile</h1></span>
            <br>
            <br>
            <p>
            <h2>${nameOfChannel}</h2></p>
            <br>
            <form method="post" action="/channelProfile">
                <p><label for="name"> Name
                    <input type="text" id="name" name="name">
                </label></p>
                <p><label for="description"> Description
                    <input type="text" id="description" name="description">
                </label></p>
                <p><label for="upload_date"> Date
                    <input type="date" id="upload_date" name="upload_date">
                </label></p>
                <p><input type="submit" name="add" value="add"></p>
            </form>
            <%--<p>Your videos:</p>--%>
            <%--<table>--%>
                <%--<tr>--%>
                    <%--<th>Name</th>--%>
                    <%--<th>Upload Date</th>--%>
                <%--</tr>--%>
                <%--<c:forEach items="${videos}" var="video">--%>
                    <%--<tr>--%>
                        <%--<td>${video.name}</td>--%>
                        <%--<td>${video.upload_date}</td>--%>
                        <%--<form method="post" action="/channelProfile">--%>
                            <%--<td>--%>
                                <%--<button name="delete" id="delete" value="${video.name}">Delete</button>--%>
                            <%--</td>--%>
                        <%--</form>--%>
                    <%--</tr>--%>
                <%--</c:forEach>--%>
            <%--</table>--%>
        </div>
        <a href="/profile">Profile</a>
        <div class="col"></div>
    </diw>
</div>
<br>
<footer id="sticky-footer" class="py-4 bg-dark text-white-50">
    <div class="container text-center">
        <small>Copyright &copy; Video Courses</small>
    </div>
</footer>
</body>
</html>