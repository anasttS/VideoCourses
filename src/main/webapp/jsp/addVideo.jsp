<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="/jsp/header.jsp" %>
    <title>Add video</title>
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