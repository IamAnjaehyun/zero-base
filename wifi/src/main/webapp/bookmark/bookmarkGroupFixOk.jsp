<%@ page import="java.sql.*" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="com.example.wifi.service.BookmarkService" %><%--
  Created by IntelliJ IDEA.
  User: jaehyun
  Date: 2023/04/04
  Time: 12:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Jaehyun</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
<%
    if (request.getMethod().equals("POST")) {

        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int num = Integer.parseInt(request.getParameter("num"));
        BookmarkService bookmarkService = new BookmarkService();
        bookmarkService.fixBookmarkGroup(id, name, num);
        response.sendRedirect("bookmarkGroup.jsp");
    }
%>

</body>
</html>
