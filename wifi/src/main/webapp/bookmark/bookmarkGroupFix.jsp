<%@ page import="com.example.wifi.dto.response.ResponseWifi" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.wifi.service.WifiService" %>
<%@ page import="com.example.wifi.service.BookmarkService" %>
<%@ page import="com.example.wifi.dto.request.RequestBookmark" %>
<%@ page import="com.example.wifi.dto.request.RequestBookmarkList" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="com.example.wifi.dto.response.ResponseBookmarkList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JaeHyun</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
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

<table>
    <thead>
    <form action="bookmarkGroupFixOk.jsp" method="POST">
        <%-- 이전 페이지에서 넘어온 id 값을 hidden 타입으로 전송합니다. --%>
        <input type="hidden" name="id" value="<%= request.getParameter("id") %>">

        <%-- DB에서 해당 북마크 그룹의 정보를 가져와서 input 태그에 기본 값으로 채웁니다. --%>
        <tr>
            <td bgcolor="#04AA6D" align="center"><label bgcolor="#04AA6D">북마크 이름</label></td>
            <td><input type="text" name="name"><br></td>
        </tr>
        <tr>
            <td bgcolor="#04AA6D" align="center"><label bgcolor="#04AA6D">순서</label></td>
                <td><input type="text" name="num"><br></td>
        </tr>
        <%-- 수정 버튼 --%>
        <tr>
            <td colspan="2">
                <input type="submit" value="수정">
            </td>
        </tr>

    </form>
    </thead>
</table>


<tr>
    <%--    북마크 list (수정 + 삭제)--%>


</tr>
</body>
</html>