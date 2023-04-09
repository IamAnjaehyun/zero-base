<%@ page import="com.example.wifi.service.BookmarkService" %>
<%@ page import="com.example.wifi.dto.response.ResponseBookmark" %>
<%@ page import="com.example.wifi.dto.response.ResponseHistory" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Jaehyun</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
<h1><%= "북마크 목록" %></h1>
</br>
<a href="../index.jsp">홈</a> |
<a href="../history.jsp">위치 히스토리 목록</a> |
<a href="../save.jsp">Open API 와이파이 정보 가져오기</a>|
<a href="../bookmark/bookmarkShow.jsp">북마크 보기</a>|
<a href="../bookmark/bookmarkGroup.jsp">북마크 그룹 관리</a>
</br>
<%
    request.setCharacterEncoding("utf-8");
    BookmarkService service = new BookmarkService();
    List<ResponseBookmark> bookmarkList = service.showBookmark();
%>
<table>
    <thead>
    <tr bgcolor="#04AA6D">
        <th><font color="white">ID</font></th>
        <th><font color="white">북마크 이름</font></th>
        <th><font color="white">와이파이명</font></th>
        <th><font color="white">등록일자</font></th>
        <th><font color="white">비고</font></th>
    </tr>
    </thead>
    <tbody>
    <% if(bookmarkList.isEmpty()) { %>
    <tr>
        <td colspan="5" rowspan="3" align="center"><br>정보가 존재하지 않습니다.<br><br></td>
    </tr>
    <% } else { %>
    <% for(ResponseBookmark bookmarkLists : bookmarkList) { %>
    <tr>
        <td><%= bookmarkLists.getID()%></td >
        <td><%= bookmarkLists.getBOOKMARK_NAME()%></td >
        <td><a href="bookmarkShowDetail.jsp?mgrNo=<%=bookmarkLists.getMGR_NO()%>"><%= bookmarkLists.getWIFI_NO() %></a></td>
        <td><%= bookmarkLists.getCREATED_TIME()%> </td>
        <td align="center"><a href="bookmarkDelete.jsp?ID=<%=bookmarkLists.getID()%>">삭제</a></td>
    </tr>
    <% }%>
    <% } %>
    </tbody>
</table>
</body>
</html>
