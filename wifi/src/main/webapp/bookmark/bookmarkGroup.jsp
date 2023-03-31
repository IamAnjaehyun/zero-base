<%@ page import="com.example.wifi.dto.response.ResponseWifi" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.wifi.service.WifiService" %>
<%@ page import="com.example.wifi.service.BookmarkService" %>
<%@ page import="com.example.wifi.dto.request.RequestBookmarkList" %>
<%@ page import="java.awt.print.Book" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="com.example.wifi.dto.response.ResponseBookmarkList" %>
<%--jstl--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JaeHyun</title>
    <style>
        .divbox {
            display: inline-flex;
        }
    </style>
</head>

<body>
<h1><%= "북마크 그룹" %>
</h1>
</br>
<a href="../index.jsp">홈</a> |
<a href="../history.jsp">위치 히스토리 목록</a> |
<a href="../save.jsp">Open API 와이파이 정보 가져오기</a>|
<a href="../bookmark/bookmarkShow.jsp">북마크 보기</a>|
<a href="../bookmark/bookmarkGroup.jsp">북마크 그룹 관리</a>
</br>
<%
    BookmarkService bookmarkService = new BookmarkService();
    List<ResponseBookmarkList> bookmarkLists = bookmarkService.showBookmarkList(); // bookmarkService에서 bookmarklist 테이블에서 name 값을 가져오는 메소드
    request.setAttribute("nameList", bookmarkLists);
%>

<select>
    <option value="">--선택--</option>
    <% for(ResponseBookmarkList bookmark : bookmarkLists) { %>
    <option value="<%= bookmark.getName() %>"><%= bookmark.getName() %></option>
    <% } %>
</select>
<button onclick="location.href='bookmarkListAdd.jsp'">북마크 추가</button>

<script>

</script>
<%
    String name = request.getParameter("name");
    String num = request.getParameter("orderNum");

    if (name != null && num != null && !name.equals("") && !num.equals("")) {
        PreparedStatement pstmt;
        Connection conn = null;
        request.setCharacterEncoding("utf-8");

        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:C:/sqllite/test.db";
            conn = DriverManager.getConnection(url);

            // 테이블 생성 후 데이터 삽입
            String sql = "insert into BOOKMARKLIST (NAME, NUM) values (?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setInt(2, Integer.parseInt(num));
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
%>
<table>
    <thead>
    <tr bgcolor="#04AA6D">
        <th><font color="white">ID</font></th>
        <th><font color="white">북마크 이름</font></th>
        <th><font color="white">등록 일자</font></th>
        <th><font color="white">수정 일자</font></th>
        <th><font color="white">비고</font></th>
    </tr>
    </thead>
</table>
<tr>
    <%--    북마크 list (수정 + 삭제)--%>
</tr>
</body>
</html>