<%@ page import="java.sql.*" %>
<%@ page import="java.time.LocalDateTime" %><%--
  Created by IntelliJ IDEA.
  User: jaehyun
  Date: 2023/04/01
  Time: 8:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    request.setCharacterEncoding("utf-8");
    // selectbox에서 선택한 bookmarklist 정보를 가져온다.
    String selectedBookmarkList = request.getParameter("listName");

    // 내가 띄운 데이터의 getX_SWIFI_MGR_NO을 가져온다.
    String xSwifiMgrNo = request.getParameter("mgrNo");

    PreparedStatement pstmt = null;
    Connection conn = null;
    request.setCharacterEncoding("utf-8");
    if (selectedBookmarkList != null && xSwifiMgrNo != null) {
        // bookmark 테이블에 데이터를 추가한다.
        try {
            Class.forName("org.sqlite.JDBC");
            // 데이터베이스 파일 경로
            String url = "jdbc:sqlite:/Users/jaehyun/Desktop/sqlite/wifi.db";


            // 데이터베이스 연결
            conn = DriverManager.getConnection(url);

            // SQL query 작성
            String sql = "INSERT INTO bookmark (BOOKMARK_NO, WIFI_NO, CREATED_TIME) VALUES (?, ? ,?)";
            // Prepare statement 생성
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, selectedBookmarkList);
            pstmt.setString(2, xSwifiMgrNo);
            pstmt.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

            // Execute query
            pstmt.executeUpdate();

            // Clean-up
            pstmt.close();
            conn.close();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="text-align: center"><h1>북마크 추가가 완료되었습니다.</h1></div>

<div style="text-align: center"><a href="bookmarkShow.jsp">북마크 보러가기</a></div>


</body>
</html>