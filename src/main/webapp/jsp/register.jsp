<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
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
<script>
    function checkPassword() {
        var password = document.getElementById('inputPassword').value;
        var passwordLengthError = document.getElementById('passwordLengthError');
        var passwordContainUpperCaseLetterError = document.getElementById('passwordContainUpperCaseLetterError');
        var passwordContainNumberError = document.getElementById('passwordContainNumberError');
        var confirmPassword = document.getElementById('confirmPassword');
        var cond1 = false;
        var cond2 = false;
        var cond3 = false;
        console.log(password);
        if (password.length < 8) {
            passwordLengthError.style.color = "red";
            cond1 = false;
        } else {
            passwordLengthError.style.color = "green";
            cond1 = true;
        }
        if (password.toString().search(/[A-Za-z]/) === -1) {
            passwordContainUpperCaseLetterError.style.color = "red";
            cond2 = false;
        } else {
            passwordContainUpperCaseLetterError.style.color = "green";
            cond2 = true;
        }
        if (password.toString().search(/\d/) === -1) {
            passwordContainNumberError.style.color = "red";
            cond3 = false;
        } else {
            passwordContainNumberError.style.color = "green";
            cond3 = true;
        }
    }

</script>
</body>
</html>