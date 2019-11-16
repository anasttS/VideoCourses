<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="/jsp/header.jsp" %>
    <title>Channel</title>
</head>
<body>
<%@ include file="/jsp/navbar.jsp" %>
<div class="channel-container">
    <div class="channel-header">
        <div class="channel-header-image">
            <img src="${img}" alt="img" class="img-thumbnail2" width="120px" height="120px">
        </div>
        <div class="channel-header-description">
            <h2>${nameOfChannel}</h2>
            <div class="fa-align-right">
                <form method="post" action="<c:url value="/channelProfile"/>">
                    <button class="btn-sm btn-primary" name="redirect" type="submit">Add Video</button>
                </form>
            </div>
        </div>
    </div>
    <div class="container-fluid">
        <div class="row">
            <tag:video/>
        </div>
    </div>
</div>

<br>
</div>
<br>
<footer id="sticky-footer" class="py-4 bg-dark text-white-50">
    <div class="container text-center">
        <small>Copyright &copy; Video Courses</small>
    </div>
</footer>
</body>
</html>