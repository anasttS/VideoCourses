<!DOCTYPE html>
<%--<%@ taglib prefix="cookie" uri="/WEB-INF/tags/MyTags.tld"%>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <title>Login</title>
</head>
<body style="background-image: url(/assets/img/bg3.jpg);">
<%@ include file="/jsp/navbar.jsp" %>
<div class="container-fluid">
    <br>
    <br>
    <div class="row">
        <div class="col"></div>
        <div class="col-md-3" align="center">
            <div class="add-video-card" style="background: rgba(255, 255, 255, 0.5);
    color: #495057;">
                <span><h1><b>Login</b></h1></span>
                <span><b>And improve yourself</b></span>
                <br>
                <br>
                <br>
                <form method="post">
                    ${message}
                    <div class="form-group">
                        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                               placeholder="Enter email" name="email">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password"
                               name="password">
                    </div>
                    <div class="custom-control custom-checkbox">
                        <input type="checkbox" class="custom-control-input" id="exampleCheck1" name="rememberMe">
                        <label class="custom-control-label" for="exampleCheck1"><b>Remember me</b></label>
                    </div>
                    <br>
                    <button type="submit" class="btn btn-primary">Login</button>
                </form>
            </div>
        </div>
        <div class="col"></div>
    </div>
</div>
<br>
</body>
</html>