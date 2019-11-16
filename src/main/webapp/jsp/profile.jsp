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
                            <!-- Default inline 1-->
                            <div class="custom-control custom-checkbox">
                                <input type="checkbox" class="custom-control-input" id="defaultInline1" name="Interest1"
                                       value="1">
                                <label class="custom-control-label" for="defaultInline1"><b>IT</b></label>
                            </div>

                            <!-- Default inline 2-->
                            <div class="custom-control custom-checkbox">
                                <input type="checkbox" class="custom-control-input" id="defaultInline2" name="Interest2"
                                       value="2">
                                <label class="custom-control-label" for="defaultInline2"><b>Math</b></label>
                            </div>

                            <!-- Default inline 3-->
                            <div class="custom-control custom-checkbox">
                                <input type="checkbox" class="custom-control-input" id="defaultInline3" name="Interest3"
                                       value="3">
                                <label class="custom-control-label" for="defaultInline3"><b>Music</b></label>
                            </div>

                            <!-- Default inline 4-->
                            <div class="custom-control custom-checkbox">
                                <input type="checkbox" class="custom-control-input" id="defaultInline4" name="Interest4"
                                       value="4">
                                <label class="custom-control-label" for="defaultInline4"><b>Business</b></label>
                            </div>

                            <!-- Default inline 5-->
                            <div class="custom-control custom-checkbox">
                                <input type="checkbox" class="custom-control-input" id="defaultInline5" name="Interest5"
                                       value="5">
                                <label class="custom-control-label" for="defaultInline5"><b>English</b></label>
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

    </div>
</div>
</div>
<br>
<br>
</body>
</html>