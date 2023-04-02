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
<h1><%= "북마크 추가" %>
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

    if (name != null && num != null && !name.equals("") && !num.equals("")) {
        PreparedStatement pstmt;
        Connection conn = null;
        request.setCharacterEncoding("utf-8");

        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:/Users/jaehyun/Desktop/sqlite/wifi.db";


            conn = DriverManager.getConnection(url);

            // 테이블 생성 후 데이터 삽입
            String sql = "insert into BOOKMARKLIST (NAME, NUM, CREATED_TIME) values (?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setInt(2, Integer.parseInt(num));
            pstmt.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
%>
<table>
    <thead>
    <form action="bookmarkListAdd.jsp" method="POST">
        <table>
            <thead>
            <tr>
                <td bgcolor="#04AA6D">북마크 이름</td>
                <td><input type="text" id="name" name="name" placeholder="제목을 입력하세요."></td>
            </tr>
            <tr>
                <td bgcolor="#04AA6D">순서</td>
                <td><input type="text" id="orderNum" name="orderNum" placeholder="숫자 형태로 입력해주세요."></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" onclick="getNameId();" value="추가">
                </td>
            </tr>
            </thead>
        </table>
    </form>
    </thead>
</table>


<tr>
    <%--    북마크 list (수정 + 삭제)--%>


</tr>
</body>
</html>