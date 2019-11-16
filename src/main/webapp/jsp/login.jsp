<!DOCTYPE html>
<%--<%@ taglib prefix="cookie" uri="/WEB-INF/tags/MyTags.tld"%>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <%@ include file="/jsp/header.jsp" %>
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