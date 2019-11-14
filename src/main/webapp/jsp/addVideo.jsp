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
<body style="background-image: url(/assets/img/bg2.jpg);">
<%@ include file="/jsp/navbar.jsp" %>
<br>
<div class="container-fluid">
    <div class="row">

        <div class="col-md-3"></div>
        <div class="col-md-6">
            <div class="add-video-card" style="background: rgba(255, 255, 255, 0.5);
    color: #495057;">
                <div class="intro">
                    <h1 class=""><b>Add your video</b></h1>
                    <h6 class=""><b>And improve others</b></h6>
                </div>
                <br>
                <br>
                <form method="post" enctype="multipart/form-data">
                    <div class="form-group">
                        <input type="text" class="form-control" id="inputUsername" placeholder="Enter video name"
                               name="videoName">
                    </div>
                    <div class="custom-file">
                        <input type="file" class="custom-file-input" id="video" name="fileM">
                        <label class="custom-file-label" for="video">Choose video file</label>
                    </div>
                    <div class="custom-file">
                        <input type="file" class="custom-file-input" id="preview" name="fileP">
                        <label class="custom-file-label" for="preview">Choose image file</label>
                    </div>
                    <br>
                    <br>
                    <div class="form-group">
                        <textarea rows="3" type="text" class="form-control" id="inputEmail"
                                  placeholder="Enter description" name="description"></textarea>
                    </div>
                    <%--<div class="form-group">--%>
                        <%--<label for="example-date-input">Tags</label>--%>
                        <%--<input class="form-control" type="text" id="example-date-input" name="videoTags"--%>
                               <%--placeholder="#tag, #tag, #tag ...">--%>
                    <%--</div>--%>
                    <br>
                    <span><h4>Choose video topics</h4></span>
                    <!-- Default inline 1-->
                    <div class="custom-control custom-checkbox">
                        <input type="checkbox" class="custom-control-input" id="defaultInline1" name="Interest1" value="1">
                        <label class="custom-control-label" for="defaultInline1"><b>IT</b></label>
                    </div>

                    <!-- Default inline 2-->
                    <div class="custom-control custom-checkbox">
                        <input type="checkbox" class="custom-control-input" id="defaultInline2" name="Interest2" value="2">
                        <label class="custom-control-label" for="defaultInline2"><b>Math</b></label>
                    </div>

                    <!-- Default inline 3-->
                    <div class="custom-control custom-checkbox">
                        <input type="checkbox" class="custom-control-input" id="defaultInline3" name="Interest3" value="3">
                        <label class="custom-control-label" for="defaultInline3"><b>Music</b></label>
                    </div>

                    <!-- Default inline 4-->
                    <div class="custom-control custom-checkbox">
                        <input type="checkbox" class="custom-control-input" id="defaultInline4" name="Interest4" value="4">
                        <label class="custom-control-label" for="defaultInline4"><b>Business</b></label>
                    </div>

                    <!-- Default inline 5-->
                    <div class="custom-control custom-checkbox">
                        <input type="checkbox" class="custom-control-input" id="defaultInline5" name="Interest5" value="5">
                        <label class="custom-control-label" for="defaultInline5"><b>English</b></label>
                    </div>
                    <br>
                    <button type="submit" class="btn btn-primary" name = "addVideo">Add video</button>
                </form>
            </div>
        </div>
        <div class="col-md-3"></div>
    </div>

</div>
<br>
<br>
</body>
</html>