<%@ page import="com.example.wifi.dto.response.ResponseWifi" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.wifi.service.WifiService" %>
<%@ page import="com.example.wifi.service.BookmarkService" %>
<%@ page import="com.example.wifi.dto.request.RequestBookmarkList" %>
<%@ page import="java.awt.print.Book" %>
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
<button onclick="location.href='bookmarkListAdd.jsp'">북마크 추가</button>

<script>

</script>
<%
    String name = request.getParameter("name");
    String orderNum = request.getParameter("orderNum");
    if (!name.equals("") && !orderNum.equals("")) {
        RequestBookmarkList requestBookmarkList = RequestBookmarkList.builder()
                .name(name)
                .id(Integer.parseInt(orderNum))
                .build();
        BookmarkService service = new BookmarkService();
        service.addBookMarkList(requestBookmarkList);
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