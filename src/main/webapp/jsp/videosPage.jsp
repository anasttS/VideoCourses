<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="/jsp/header.jsp" %>
    <title>Videos</title>
</head>
<body>
<%@ include file="/jsp/navbar.jsp" %>


<form action="<c:url value="/video"/>" method="get" id="searchForm" class="channel-header">
    <div class="input-group-btn search-panel">
        <select name="search_param" id="search_param" class="btn btn-default dropdown-toggle"
                data-toggle="dropdown" onfocus="">
            <option value="video">Video</option>
            <option value="username">Username</option>
            <option value="channelName">ChannelName</option>
        </select>
    </div>
    <input type="text" class="form-control mr-sm-2" name="x" id="query" oninput="f()"
           placeholder="Search term...">
</form>

<tag:Ajax/>

<div id="res"></div>
<div class="features-clean">
    <div class="intro">
        <h2 class="text-center">All videos: </h2>
    </div>
</div>
<div class="channel-container">
    <div class="card-container">
        <div class="d-flex flex-wrap">
            <tag:video/>
        </div>
    </div>
</div>
<%--<%}%>--%>
<br>
<br>
<footer id="sticky-footer" class="py-4 bg-dark text-white-50">
    <div class="container text-center">
        <small>Copyright &copy; Video Courses</small>
    </div>
</footer>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/bootstrap.bundle.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/js/swiper.jquery.min.js"></script>
<script src="assets/js/Simple-Slider.js"></script>
</body>
</html>