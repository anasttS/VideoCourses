<%@tag pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:forEach var="video" items="${videos}">
    <div class="card-container">
        <div class="d-flex flex-wrap">
            <div class="card" style="width: 18rem;">
                <img src="${video.img}" class="card-img-top" alt="...">
                <div class="card-body" style="height: 185px;">
                    <h5 class="card-title">${video.name}</h5>
                    <p class="card-text">${video.description}</p>
                    <form action="/video" method="get">
                        <button type="submit" class="btn btn-primary" value="${video.id_video}" name="id">
                            Watch
                            video
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</c:forEach>