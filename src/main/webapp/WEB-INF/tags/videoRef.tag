<%@tag pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:forEach var="v" items="${videos}">
    <a href="/video?id=${v.id_video}">>
        <div class="small-video-card">
            <div class="row" style="padding: 0px;">
                <div class="col-md-6">
                    <img src="${v.img}" alt="" class="card-img-left">
                </div>
                <div class="col" style="padding: 0">
                    <div>
                        <small>${v.name}</small>
                        <br>
                        <small>${v.likes} likes</small>
                        <br>
                    </div>
                </div>
            </div>
        </div>
    </a>
</c:forEach>