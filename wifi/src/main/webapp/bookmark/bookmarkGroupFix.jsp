<%@ page import="com.example.wifi.dto.response.ResponseWifi" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.wifi.service.WifiService" %>
<%@ page import="com.example.wifi.service.BookmarkService" %>
<%@ page import="com.example.wifi.dto.request.RequestBookmark" %>
<%@ page import="com.example.wifi.dto.request.RequestBookmarkList" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<body>
<h1><%= "북마크 크룹 수정" %>
</h1>
</br>
<a href="../index.jsp">홈</a> |
<a href="../history.jsp">위치 히스토리 목록</a> |
<a href="../save.jsp">Open API 와이파이 정보 가져오기</a>|
<a href="../bookmark/bookmarkShow.jsp">북마크 보기</a>|
<a href="../bookmark/bookmarkGroup.jsp">북마크 그룹 관리</a>
</br>


<script>
    function getNameId() {
        let name = document.getElementById("name");
        let orderNumStr = document.getElementById("orderNum");
        if (name === "" || orderNumStr === "") {
            alert("비어있는 값 존재.");
        }
    }
</script>
<%
    request.setCharacterEncoding("utf-8");
    String name = request.getParameter("name");
    int num = Integer.parseInt(request.getParameter("num"));

    if (name != null && request.getParameter("num") != null && !name.equals("") && !request.getParameter("num").equals("")) {
        PreparedStatement pstmt;
        Connection conn = null;
        request.setCharacterEncoding("utf-8");

        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:/Users/jaehyun/Desktop/sqlite/wifi.db";

            conn = DriverManager.getConnection(url);

            // 데이터 수정
            String sql = "UPDATE BOOKMARKLIST SET NAME=?, NUM=?, FIXED_TIME=? WHERE ID=?";
            pstmt = conn.prepareStatement(sql);

            // 매개변수에 값을 전달합니다.
            pstmt.setString(1, name);
            pstmt.setInt(2, num);
            pstmt.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

            // SQL문을 실행합니다.
            int result = pstmt.executeUpdate();

            if (result == 1) {
                // 수정이 성공했을 경우
                response.sendRedirect(request.getContextPath() + "/bookmark/bookmarkList.jsp");
            } else {
                // 수정이 실패했을 경우
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to edit bookmark.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to edit bookmark: " + e.getMessage());
        } finally {
            try {
                // 데이터베이스 연결과 PreparedStatement 객체를 닫습니다.
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

%>
<table>
    <thead>
    <form action="bookmarkUpdate" method="post">
        <!-- hidden 타입으로 수정할 북마크의 ID 값을 전송합니다. -->
        <input type="hidden" name="bookmarkId" value="<%= bookmark.getBOOKMARK_ID() %>">
        <label for="name">북마크 이름:</label>
        <input type="text" name="name" value="<%= bookmark.getBOOKMARK_NAME() %>"><br>
        <label for="num">와이파이 번호:</label>
        <input type="text" name="num" value="<%=book() %>"><br>
        <input type="submit" value="수정">
    </form>
    </thead>
</table>


<tr>
    <%--    북마크 list (수정 + 삭제)--%>


</tr>
</body>
</html>