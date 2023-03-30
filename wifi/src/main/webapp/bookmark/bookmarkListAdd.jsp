<%@ page import="com.example.wifi.dto.response.ResponseWifi" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.wifi.service.WifiService" %>
<%@ page import="com.example.wifi.service.BookmarkService" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="com.example.wifi.dto.request.RequestBookmark" %>
<%@ page import="com.example.wifi.dto.request.RequestBookmarkList" %>
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

</script>

<script>
    function getNameId() {
        let name = document.getElementById("name");
        let orderNumStr = document.getElementById("orderNum");
        if (name === "" || orderNumStr === "") {
            alert("비어있는 값 존재.");
        }
    }

</script>

<table>
    <thead>
    <form action="bookmarkGroup.jsp" method="POST">
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
                    <input type="submit" value="추가">
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

<head>
    <title>JaeHyun</title>
    <style>
        .divbox {
            display: inline-flex;
        }
    </style>
</head>
</html>