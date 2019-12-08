<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="/jsp/header.jsp" %>
    <title>Profile</title>
</head>
<body style="background-image: url(/assets/img/bg5.jpg);">
<%@ include file="/jsp/navbar.jsp" %>

<br>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8">
            <div class="row">
                <div class="col-md-4">
                    <img src="${img}" class="img-thumbnail2" alt="..." width="200px" height="200px">
                </div>
                <div class="col-md-8">
                    <div class="add-video-card" style="background: rgba(255, 255, 255, 0.5);
    color: #495057;">
                        <span><h3><b>Profile ${username}</b></h3></span>
                        <form method="post" action="<c:url value="/profile"/>">
                            <div class="form-group">
                                <label for="inputUsername"><b>Username</b></label>
                                <input type="text" class="form-control" id="inputUsername" placeholder="Enter username"
                                       name="username" value="${username}">
                            </div>
                            <div class="form-group">
                                <label for="inputEmail"><b>Email address</b></label>
                                <input type="email" class="form-control" id="inputEmail" placeholder="Enter email"
                                       name="email" value="${email}">
                            </div>
                            <div class="form-group">
                                <label for="example-date-input"><b>Birth Date</b></label>
                                <input class="form-control" type="date" id="example-date-input" name="birthDate"
                                       value="${birthDate}">
                            </div>
                            <hr>
                            <span><b>Choose you interests</b></span>
                            <c:forEach var="interest" items="${AllInterests}">
                                    <div class="custom-control custom-checkbox">
                                        <input type="checkbox" class="custom-control-input" id="${interest.getKey()}"
                                               name="Interest${interest.getKey()}"
                                        <c:forEach var="UserInterest" items="${interests}">
                                        <c:if test="${UserInterest.getKey() == interest.getKey()}"> checked value="on" </c:if>
                                        </c:forEach>
                                               value="off">
                                        <label class="custom-control-label"
                                               for="${interest.getKey()}"><b>${interest.getValue()}</b></label>
                                    </div>
                            </c:forEach>


                            <button type="submit" class="btn btn-primary" name="save">Save Changes</button>
                            <button type="submit" class="btn btn-primary" name="createChannel">Create channel</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    function MyFunction() {
        var check = document.getElementById(id);
        check.checked = !check.checked;
    }
</script>
<br>
<br>

</body>
</html>