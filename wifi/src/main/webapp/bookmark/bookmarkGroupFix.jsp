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
<h1><%= "북마크 그룹 수정" %>
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
        <input type="hidden" name="id" value="<%= request.getParameter("id") %>">
        <tr>
            <td bgcolor="#04AA6D" align="center"><label bgcolor="#04AA6D">북마크 이름</label></td>
            <td><input type="text" name="name"><br></td>
        </tr>
        <tr>
            <td bgcolor="#04AA6D" align="center"><label bgcolor="#04AA6D">순서</label></td>
                <td><input type="text" name="num"><br></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" onclick="getNameId()" value="수정">
            </td>
        </tr>

    </form>
    </thead>
</table>
<script>
    function getNameId() {
        let name = document.getElementById("name");
        let orderNumStr = document.getElementById("num");
        if (name === "" || orderNumStr === "") {
            alert("비어있는 값 존재.");
        }else{
            alert("수정 성공!")
        }
    }
</script>
</body>
</html>