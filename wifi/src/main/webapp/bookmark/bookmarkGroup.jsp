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
<%@ page import="com.example.wifi.dto.response.ResponseBookmark" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>JaeHyun</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
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
    request.setCharacterEncoding("utf-8");
    BookmarkService bookmarkService = new BookmarkService();
    List<ResponseBookmarkList> bookmarkGroupList = null;
    try {
        bookmarkGroupList = bookmarkService.showBookmarkGroupList();
    } catch (Exception e) {
        e.printStackTrace();
    }
%>

<button onclick="location.href='bookmarkGroupAdd.jsp'">북마크 추가하기</button>


<table>
    <thead>
    <tr bgcolor="#04AA6D">
        <th><font color="white">ID</font></th>
        <th><font color="white">북마크 이름</font></th>
        <th><font color="white">순서</font></th>
        <th><font color="white">등록 일자</font></th>
        <th><font color="white">수정 일자</font></th>
        <th><font color="white">비고</font></th>
    </tr>
    </thead>
    <tbody>
    <% if (bookmarkGroupList.isEmpty()) { %>
    <tr>
        <td colspan="6" rowspan="3" align="center"><br>정보가 존재하지 않습니다.<br><br></td>
    </tr>
    <% } else { %>
    <% for(ResponseBookmarkList bookmarkGroupLists : bookmarkGroupList) { %>
    <tr>
        <td><%= bookmarkGroupLists.getID()%></td >
        <td id="MGR_NO"><%= bookmarkGroupLists.getName()%></td >
        <td><%= bookmarkGroupLists.getNUM() %> </td>
        <td><%= bookmarkGroupLists.getCREATED_TIME()%></td>
        <td><%= bookmarkGroupLists.getFIXED_TIME()%></td>
        <td align="center"> <a href="bookmarkGroupFix.jsp?id=<%= bookmarkGroupLists.getID() %>&name=<%= URLEncoder.encode(bookmarkGroupLists.getName(), "UTF-8") %>&num=<%= bookmarkGroupLists.getNUM() %>">수정</a>
                            <a href="bookmarkGroupDelete.jsp?id=<%= bookmarkGroupLists.getID() %>&name=<%= URLEncoder.encode(bookmarkGroupLists.getName(), "UTF-8") %>&num=<%= bookmarkGroupLists.getNUM() %>">삭제</a></td>
    </tr>
    <% } %>
    <% }%>
    </tbody>
</table>
<tr>
    <%--    북마크 list (수정 + 삭제)--%>
</tr>
</body>
</html>