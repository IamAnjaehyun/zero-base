<%@ page import="com.example.wifi.service.BookmarkService" %><%--
  Created by IntelliJ IDEA.
  User: jaehyun
  Date: 2023/04/03
  Time: 10:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Jaehyun</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<%
    if (request.getMethod().equals("POST")) {
        int id = Integer.parseInt(request.getParameter("bookmarkId"));
        BookmarkService bookmarkService = new BookmarkService();
        bookmarkService.deleteBookmark(id);
        response.sendRedirect("bookmarkShow.jsp");
    }
%>
<body>
삭제 페이지
</body>
</html>
