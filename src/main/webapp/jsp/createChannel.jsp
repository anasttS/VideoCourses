<%--
  Created by IntelliJ IDEA.
  User: smysh
  Date: 20.10.2019
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <%@ include file="/jsp/header.jsp" %>
    <title>Create channel</title>
</head>
<body style="background-image: url(/assets/img/bg1.jpg);">
<%@ include file="/jsp/navbar.jsp" %>
<div class="container-fluid">
    <br>
    <br>
    <div class="row">
        <div class="col"></div>
        <div class="col-md-3" align="center">
            <div class="add-video-card" style="background: rgba(255, 255, 255, 0.5);
    color: #495057;">
                <span><h1><b>Create channel</b></h1></span>
                <br>
                <br>
                <form method="post" enctype="multipart/form-data">
                    <div class="form-group">
                        <input type="text" class="form-control" id="name"  placeholder="Enter name" name="nameOfChannel">
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" id="description"  placeholder="Enter description" name="nameOfChannel">
                    </div>
                    <div class="custom-file">
                        <input type="file" class="custom-file-input" id="preview" name="fileP">
                        <label class="custom-file-label" for="preview">Add photo</label>
                    </div>
                    <br>
                    <br>
                    <button type="submit" class="btn btn-primary" name="createChannel">Create channel</button>
                </form>
            </div>
        </div>
        <div class="col"></div>
    </div>
</div>
<br>
</body>
</html>