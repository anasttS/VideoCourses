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
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-dark">
    <a class="navbar-brand text-white" href="#">Navbar</a>
</nav>
<div class="container-fluid">
    <br>
    <br>
    <diw class="row">
        <div class="col"></div>
        <div class="col-md-3" align="center">
            <span><h1>Register</h1></span>
            <span>And improve yourself</span>
            <br>
            <br>
            <br>
            <form method="post">
                <div class="form-group">
                    <label for="inputUsername">Username</label>
                    <input type="text" class="form-control" id="inputUsername" placeholder="Enter username" name="username">
                </div>
                <div class="form-group">
                    <label for="inputEmail">Email address</label>
                    <input type="email" class="form-control" id="inputEmail" placeholder="Enter email" name="email">
                </div>
                <div class="form-group">
                    <label for="inputPassword">Password</label>
                    <input type="password" class="form-control" id="inputPassword" placeholder="Password" name="password">
                </div>
                <div class="form-group">
                    <label for="example-date-input">Birth Date</label>
                    <input class="form-control" type="date" id="example-date-input" name="birthDate">
                </div>
                <br>
                <span><h4>Choose your interests</h4></span>
                <p><label>
                    <select size="6" multiple="multiple" name="interests">
                        <option disabled> Choose your interests </option>
                        <option value="IT" selected="selected"> IT </option>
                        <option value="Math"> Math </option>
                        <option value="Languages"> Languages </option>
                        <option value="Medicine"> Medicine </option>
                        <option value="Psychology"> Psychology </option>
                        <option value="Business"> Business </option>
                    </select>
                </label></p>
                <%--<div class="form-check">--%>
                    <%--<input class="form-check-input" type="checkbox" value="" id="InterestCheck1">--%>
                    <%--<label class="form-check-label" for="InterestCheck1">--%>
                        <%--Interest--%>
                    <%--</label>--%>
                <%--</div>--%>
                <%--<div class="form-check">--%>
                    <%--<input class="form-check-input" type="checkbox" value="" id="InterestCheck2">--%>
                    <%--<label class="form-check-label" for="InterestCheck2">--%>
                        <%--Interest--%>
                    <%--</label>--%>
                <%--</div>--%>
                <%--<div class="form-check">--%>
                    <%--<input class="form-check-input" type="checkbox" value="" id="InterestCheck3">--%>
                    <%--<label class="form-check-label" for="InterestCheck3">--%>
                        <%--Interest--%>
                    <%--</label>--%>
                <%--</div>--%>
                <%--<div class="form-check">--%>
                    <%--<input class="form-check-input" type="checkbox" value="" id="InterestCheck4">--%>
                    <%--<label class="form-check-label" for="InterestCheck4">--%>
                        <%--Interest--%>
                    <%--</label>--%>
                <%--</div>--%>
                <%--<div class="form-check">--%>
                    <%--<input class="form-check-input" type="checkbox" value="" id="InterestCheck5">--%>
                    <%--<label class="form-check-label" for="InterestCheck5">--%>
                        <%--Interest--%>
                    <%--</label>--%>
                <%--</div>--%>
                <br>
                <button type="submit" class="btn btn-primary" name="register">Submit</button>
            </form>
        </div>
        <div class="col"></div>
    </diw>
</div>
<br>
<footer id="sticky-footer" class="py-4 bg-dark text-white-50">
    <div class="container text-center">
        <small>Copyright &copy; Video Courses</small>
    </div>
</footer>
</body>
</html>