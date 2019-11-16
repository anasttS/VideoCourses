<%--
  Created by IntelliJ IDEA.
  User: smysh
  Date: 10.11.2019
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
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
        </ul>
        <ul class="navbar-nav ml-auto">
            <tag:navbar/>
        </ul>
    </div>
</nav>

</body>
</html>
