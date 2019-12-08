<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lectio</title>
    <%@ include file="/jsp/header.jsp" %>
</head>

<body>
<%@ include file="/jsp/navbar.jsp" %>
<div class="container-fluid">
    <div class="video-container">
        <div class="row">
            <div class="col-8">
                <div class="video">
                    <iframe allowfullscreen="" frameborder="0"
                            src="${video.url}" class=""></iframe>
                </div>
                <br>
                <div class="row video-info">
                    <div class="col">
                        <span><h2>${video.name}</h2></span>
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="col-md-6">
                        <span>${video.views} views | ${video.uploadDate}</span>
                    </div>
                    <div class="col-md-6 d-flex flex-row-reverse align-items-center">
                        <form method="post" action="/video">
                            <input type="hidden" name="id" value="${video.idVideo}">
                            <button type="submit" class="btn btn-primary btn-sm" name="like">Like</button>
                        </form>
                        <span class="likes-count">${video.likes} Likes</span>
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col-md-3">
                        <div class="small-channel-info d-flex d-lg-inline">
                            <img src="${imgOfChannel}" alt="channel logo" class="small-channel-image"
                                 style="width: 50px; height: 50px;">
                            <span>${nameOfChannel}</span>
                        </div>
                    </div>

                </div>
                <br>
                <div class="row">
                    <div class="video-description">
                        <span>${video.description}</span>
                    </div>
                </div>
                <hr>
                <h4>Comments</h4>
                <div class="form-group">
                    <form action="/video" method="post" class="d-flex d-flex">
                        <input type="text" name="text" class="form-control" placeholder="Write a comment"
                               style="margin-right: 10px;">
                        <input type="hidden" name="id" value="${video.idVideo}">
                        <button type="submit" class="btn btn-primary" name="send" value="${video.idVideo}">Send
                        </button>
                    </form>
                </div>
                <hr>
                <c:forEach var="comment" items="${comments}">
                    <div class="comment-card">
                        <div class="row">
                            <div class="col">
                                <span><h5><c:out value="${comment.userName}"/></h5></span>
                                <small><c:out value="${comment.date}"/></small>
                                <div class="col comment-text">
                                    <span><c:out value="${comment.text}"/></span>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div class="col-4" style="padding-left: 30px;">
                <form action="<c:url value="/video?id=${video.idVideo}"/>" method="post">
                    <div class="form-group"><textarea class="form-control"
                                                      style="width: 100%;height: 200px;margin-right: 20px;"
                                                      name="noteText"></textarea>
                        <input type="hidden" name="id" value="${video.idVideo}">
                        <button name="save" class="btn btn-primary" type="submit" style="margin: 0px;margin-top: 20px;">
                            Save note
                        </button>
                    </div>
                </form>
                <hr>
                <div>
                    <tag:videoRef/>
                </div>
            </div>


        </div>
    </div>
</div>
</body>

</html>