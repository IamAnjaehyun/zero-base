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
    request.setCharacterEncoding("utf-8");
    BookmarkService bookmarkService = new BookmarkService();
    List<ResponseBookmarkList> bookmarkLists = bookmarkService.showBookmarkList(); // bookmarkService에서 bookmarklist 테이블에서 name 값을 가져오는 메소드
    List<ResponseBookmarkList> bookmarkGroupList = bookmarkService.showBookmarkGroupList(); // bookmarkService에서 bookmarklist 테이블에서 name 값을 가져오는 메소드
    request.setAttribute("nameList", bookmarkLists);
%>

<button onclick="location.href='bookmarkListAdd.jsp'">북마크 추가하기</button>

<script>

</script>

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
    <tr>
            <% for(ResponseBookmarkList bookmarkGroupLists : bookmarkGroupList) { %>
    <tr>
        <td><%= bookmarkGroupLists.getID()%></td >
        <td id="MGR_NO"><%= bookmarkGroupLists.getName()%></td >
        <td><%= bookmarkGroupLists.getNUM() %> </td>
        <td><%= bookmarkGroupLists.getCREATED_TIME()%> </td>
        <td><%=bookmarkGroupLists.getFIXED_TIME()%></td>
        <td><a href="bookmarkGroupFix.jsp?id=<%= bookmarkGroupLists.getID() %>">수정</a>
            <form method="post" action="bookmarkGroupDeleteOk.jsp">
                <input type="hidden" name="bookmarkId" value="<%= bookmarkGroupLists.getID() %>">
                <input type="submit" value="삭제">
            </form>
        </td>



    </tr>
    <% }%>
    </tr>
    </tbody>
</table>
<tr>
    <%--    북마크 list (수정 + 삭제)--%>
</tr>
</body>
</html>