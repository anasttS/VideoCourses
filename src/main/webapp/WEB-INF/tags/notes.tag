<%@tag pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:forEach var="note" items="${notes}">
    <div class="card" style="width: 17rem;">
        <div class="card-body">
            <h5 class="card-title">${video.name}</h5>
            <p class="card-text"> ${note.text}</p>
            <button type="button" name="seeNote" class="btn btn-primary" data-toggle="modal"
                    data-target="#note${note.id}">
                See note
            </button>
            <a href="<c:url value="/video?id=${note.id_video}"/>" class="card-link">Video</a>
        </div>
    </div>
    <div class="modal fade" id="note${note.id}" tabindex="-1" role="dialog"
         aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Note</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                </div>
                <form action="/notes" method="post">
                    <div class="form-group" align="center">
                                        <textarea type="text" class="form-control note" name="note"
                                                  rows="5">${note.text}</textarea>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-primary" name="edit"
                                value="${note.id}">
                            Save
                        </button>
                        <button type="submit" class="btn btn-secondary" name="delete"
                                value="${note.id}">
                            Delete
                        </button>
                    </div>
                </form>

            </div>
        </div>
    </div>
</c:forEach>