<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="/jsp/header.jsp" %>

    <title>Notes</title>
</head>
<body>
<%@ include file="/jsp/navbar.jsp" %>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8">
            <div class="card-container">
                <div class="d-flex flex-wrap">
                    <tag:notes/>
                </div>
            </div>
        </div>
        <div class="col-md-2"></div>
    </div>
</div>
<footer id="sticky-footer" class="py-4 bg-dark text-white-50">
    <div class="container text-center">
        <small>Copyright &copy; Video Courses</small>
    </div>
</footer>
</body>
</html>