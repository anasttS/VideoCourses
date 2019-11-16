<%@tag pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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