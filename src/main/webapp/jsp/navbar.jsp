<%--
  Created by IntelliJ IDEA.
  User: smysh
  Date: 10.11.2019
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand logo" href="<c:url value="/main"/>">Lectio</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-333"
            aria-controls="navbarSupportedContent-333" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent-333">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link text-white" href="/main">Main</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-white" href="/allVideos">All Videos
                    <span class="sr-only">(current)</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-white" href="/videos">Interesting Videos
                    <span class="sr-only">(current)</span>
                </a>
            </li>

            <%--<li class="nav-item">--%>
            <%--<a class="nav-link text-white" href="#">Pricing</a>--%>
            <%--</li>--%>
            <%--<li class="nav-item dropdown">--%>
            <%--<a class="nav-link dropdown-toggle text-white" id="navbarDropdownMenuLink-3333" data-toggle="dropdown"--%>
            <%--aria-haspopup="true" aria-expanded="false">Dropdown--%>
            <%--</a>--%>
            <%--<div class="dropdown-menu dropdown-default" aria-labelledby="navbarDropdownMenuLink-3333">--%>
            <%--<a class="dropdown-item" href="#">Action</a>--%>
            <%--<a class="dropdown-item" href="#">Another action</a>--%>
            <%--<a class="dropdown-item" href="#">Something else here</a>--%>
            <%--</div>--%>
            <%--</li>--%>
        </ul>
        <ul class="navbar-nav ml-auto">
            <c:if test="${auth != null}">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle text-white" id="main" data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                            ${username}
                    </a>
                    <div class="dropdown-menu dropdown-menu-right dropdown-default"
                         aria-labelledby="profile">
                        <a class="dropdown-item" href="<c:url value="/profile"/>">Profile</a>
                        <a class="dropdown-item" href="<c:url value="/channelProfile"/>">Channel</a>
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
        </ul>
    </div>
</nav>

</body>
</html>
