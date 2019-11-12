<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<cookie>
    Cookie[] cookies = request.getCookies();
    for (Cookie c : cookies) {
        if (c.getName().equals("cookemail")) {
            session.setAttribute("current_user", c.getValue());
        }
    }
</cookie>