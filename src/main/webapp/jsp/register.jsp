<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="/jsp/header.jsp" %>
    <title>Register</title>
</head>
<body style="background-image: url(/assets/img/bg5.jpg);">
<%@ include file="/jsp/navbar.jsp" %>


<div class="container-fluid">
    <br>
    <br>
    <div class="row">
        <div class="col-md-6"></div>
        <div class="col-md-5" align="center">
            <div class="add-video-card" style="background: rgba(255, 255, 255, 0.5);
    color: #495057;">
                <span><h1>Register</h1></span>
                <span>And improve yourself</span>
                <br>
                <br>
                <br>
                <form method="post" enctype="multipart/form-data">
                    <div class="form-group">
                        <input type="text" class="form-control" id="inputUsername" placeholder="Enter username"
                               name="username">
                    </div>
                    ${message}
                    <div class="form-group">
                        <input type="email" class="form-control" id="inputEmail" placeholder="Enter email" name="email">
                    </div>
                    <div class="form-group">
                        <input type="password" oninput="checkPassword()" class="form-control" id="inputPassword"
                               placeholder="Password"
                               name="password">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" id="inputCheckPassword"
                               placeholder="Repeat password"
                               name="passwordRepeat">
                    </div>
                    <div class="form-group">
                        <input class="form-control" type="date" id="example-date-input" name="birthDate">
                    </div>
                    <div class="custom-file">
                        <input type="file" class="custom-file-input" id="preview" name="fileP">
                        <label class="custom-file-label" for="preview">Add your photo</label>
                    </div>
                    <p></p>
                    <div class="form-group">
                        <div class="card-body__text-info" style="color: #000000; font-size: 16px">
                            Your password should follow requirements:
                            <ul>
                                <li id="passwordLengthError">
                                    Password should be at least 8 characters long
                                </li>
                                <li id="passwordContainUpperCaseLetterError">
                                    Password should contain at least 1 letter
                                </li>
                                <li id="passwordContainNumberError">
                                    Password should contain at least 1 number
                                </li>
                            </ul>
                        </div>
                    </div>
                    <br>
                    <button type="submit" class="btn btn-primary" name="register">Register</button>
                </form>
            </div>
        </div>
        <div class="col"></div>
    </div>
</div>
<br>
<tag:checkPassword/>
</body>
</html>