<%@ page import="BL.UserService" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--<jsp:useBean id="username" class="pages.ProfileServlet" scope="session">--%>
<%--<% UserService userService = new UserService(); %>--%>
<%--<jsp:setProperty name="username" property="username"--%>
<%--value=" <%= userService.getUsernameByEmail((String) request.getSession().getAttribute("current_user")) %>"/>--%>
<%--<jsp:setProperty name="email" property="email"--%>
<%--value=" <%= (String) request.getSession().getAttribute("current_user") %>"/>--%>
<%--<jsp:setProperty name="birthDate" property="birthDate"--%>
<%--value=" <%= userService.getbirthDateByEmail((String) request.getSession().getAttribute("current_user")) + ""  %>"/>--%>
<%--<jsp:setProperty name="auth" property="email"--%>
<%--value=" <%= (String) request.getSession().getAttribute("current_user") %>"/>--%>
<%--</jsp:useBean>--%>


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
    <title>Profile</title>
</head>
<body>
<%@ include file="/jsp/navbar.jsp" %>

<br>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-2">
            <img src="${img}" class="img-thumbnail2" alt="..." width="200px" height="200px">
        </div>
        <div class="col-md-8">
            <span><h3>Profile ${username}</h3></span>
            <form method="post" action="<c:url value="/profile"/>">
                <div class="form-group">
                    <label for="inputUsername">Username</label>
                    <input type="text" class="form-control" id="inputUsername" placeholder="Enter username"
                           name="username" value="${username}">
                </div>
                <div class="form-group">
                    <label for="inputEmail">Email address</label>
                    <input type="email" class="form-control" id="inputEmail" placeholder="Enter email"
                           name="email" value="${email}">
                </div>
                <div class="form-group">
                    <label for="inputPassword">Password</label>
                    <input type="password" class="form-control" id="inputPassword" placeholder="Password"
                           name="password">
                </div>
                <div class="form-group">
                    <label for="example-date-input">Birth Date</label>
                    <input class="form-control" type="date" id="example-date-input" name="birthDate"
                           value="${birthDate}">
                </div>
                <hr>
                <span><h6>Choose you interests</h6></span>
                <!-- Default inline 1-->
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="defaultInline1" value="IT" name="Interest1">
                    <label class="custom-control-label" for="defaultInline1">IT</label>
                </div>

                <!-- Default inline 2-->
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="defaultInline2" value="Math"
                           name="Interest2">
                    <label class="custom-control-label" for="defaultInline2">Math</label>
                </div>

                <!-- Default inline 3-->
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="defaultInline3" value="Business"
                           name="Interest3">
                    <label class="custom-control-label" for="defaultInline3">Business</label>
                </div>

                <!-- Default inline 3-->
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="defaultInline4" value="Music"
                           name="Interest3">
                    <label class="custom-control-label" for="defaultInline3">Music</label>
                </div>

                <!-- Default inline 3-->
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="defaultInline5" value="English"
                           name="Interest3">
                    <label class="custom-control-label" for="defaultInline3">English</label>
                </div>
                <br>
                <button type="submit" class="btn btn-primary" name="save">Save Changes</button>
                <button type="submit" class="btn btn-primary" name="createChannel">Create channel</button>
                <button type="submit" class="btn btn-primary" name="delete">Delete account</button>

            </form>
        </div>
    </div>
</div>
</div>
<br>
<br>
<footer id="sticky-footer" class="py-4 bg-dark text-white-50">
    <div class="container text-center">
        <small>Copyright &copy; Video Courses</small>
    </div>
</footer>
</body>
</html>