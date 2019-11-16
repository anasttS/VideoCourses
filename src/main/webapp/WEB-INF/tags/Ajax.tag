<%@tag pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="application/javascript">
    function f() {
        if ($("#query").val().length >= 1) {
            $.ajax({
                    url: "/doSearch",
                    data: {"query": $("#query").val(), "search_param": $("#search_param").val()},
                    dataType: "json",
                    success: function (msg) {
                        if (msg.videos.length > 0) {
                            // var t = document.getElementById("b");
                            // window.location.replace("videoPage.jsp?t="+t);
                            $("#res").html("");
                            for (var i = 0; i < msg.videos.length; i++) {
                                var o = msg.videos[i];
                                var id_video = o.id_video;
                                var img = o.img;
                                var name = o.name;
                                var description = o.description;

                                $("#res").append("<div class=\"channel-container\">\n" +
                                    "    <div class=\"card-container\">\n" + "  <a href=\"/video?id=" + id_video + "\">>\n" +
                                    "        <div class=\"small-video-card\">\n" +
                                    "            <div class=\"row\" style=\"padding: 0px;\">\n" +
                                    "                <div class=\"col-md-6\">\n" +
                                    "                    <img src=\"" + img + "\" alt=\"\" class=\"card-img-left\">\n" +
                                    "                </div>\n" +
                                    "                <div class=\"col\" style=\"padding: 0\">\n" +
                                    "                    <div>\n" +
                                    "                        <small>" + name + "</small>\n" +
                                    "                        <br>\n" +
                                    "                        <small> " + description + "</small>\n" +
                                    "                        <br>\n" +
                                    "                    </div>\n" +
                                    "                </div>\n" +
                                    "            </div>\n" +
                                    "        </div>\n" +
                                    "    </a>" +
                                    "                </div> </div> </div> </div>");
                            }
                        } else {
                            $("#res").html("No results..");
                        }
                    }
                }
            )
        } else {
            $("#res").html("");
        }
    }
</script>
