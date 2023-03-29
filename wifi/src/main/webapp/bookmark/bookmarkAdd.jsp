<%@ page import="com.example.wifi.dto.response.ResponseWifi" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.wifi.service.WifiService" %>
<%@ page import="com.example.wifi.service.BookmarkService" %>
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
<h1><%= "북마크 추가" %>
</h1>
</br>
<a href="index.jsp">홈</a> |
<a href="history.jsp">위치 히스토리 목록</a> |
<a href="save.jsp">Open API 와이파이 정보 가져오기</a>|
<a href="bookmark/bookmarkShow.jsp">북마크 보기</a>|
<a href="bookmark/bookmarkGroup.jsp">북마크 그룹 관리</a>
</br>
<button onclick="location.href='bookmarkAdd.jsp'">북마크 추가</button>

<script>

</script>
<%
    BookmarkService bookmarkService = new BookmarkService();
%>
<table>
    <thead>
    <form action="bookmarkGroup.jsp" method="post">
        <tr>
            <td bgcolor="#04AA6D">북마크 이름</td>
            <td><input type="text" id="name" , name="name" value="제목을 입력하세요."></td>
        </tr>
        <tr>
            <td bgcolor="#04AA6D">순서</td>
            <td><input type="text" id="order" , name="order" value="숫자만 입력하세요."></td>
        </tr>

        <tr>
            <td colspan="2">
                <input onclick="<%=bookmarkService.fixBookmark(request.getParameter("name"), Integer.parseInt(request.getParameter("order")))%>; location.href='bookmarkGroup.jsp';"
                       type="button" value="추가">
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