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
    String num = request.getParameter("orderNum");
    String id = request.getParameter("id"); // 수정할 데이터의 Primary Key 값

    if (name != null && num != null && !name.equals("") && !num.equals("") && id != null && !id.equals("")) {
        PreparedStatement pstmt;
        Connection conn = null;
        request.setCharacterEncoding("utf-8");

        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:/Users/jaehyun/Desktop/sqlite/wifi.db";

            conn = DriverManager.getConnection(url);

            // 데이터 수정
            String sql = "update BOOKMARKLIST set NAME=?, NUM=?, FIXED_TIME=? where ID=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setInt(2, Integer.parseInt(num));
            pstmt.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            pstmt.setInt(4, Integer.parseInt(id));
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

%>
<table>
    <thead>
    <form action="bookmarkUpdate" method="post">
        <!-- hidden 타입으로 수정할 북마크의 ID 값을 전송합니다. -->
        <input type="hidden" name="bookmarkId" value="<%= bookmark.getBOOKMARK_ID() %>">
        <label for="NAME">북마크 이름:</label>
        <input type="text" name="bookmarkName" value="<%= bookmark.getBOOKMARK_NAME() %>"><br>
        <label for="NUM">와이파이 번호:</label>
        <input type="text" name="wifiNo" value="<%= bookmark.getWIFI_NO() %>"><br>
        <input type="submit" value="수정">
    </form>
    </thead>
</table>


<tr>
    <%--    북마크 list (수정 + 삭제)--%>


</tr>
</body>
</html>