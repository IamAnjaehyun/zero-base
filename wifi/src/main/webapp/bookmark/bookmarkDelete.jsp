<%@ page import="com.example.wifi.service.BookmarkService" %>
<%@ page import="com.example.wifi.dto.response.ResponseBookmark" %>
<%@ page import="com.example.wifi.dto.response.ResponseHistory" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ANJH
  Date: 2023-03-29
  Time: 오후 3:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>JaeHyun</title>
  <style>
    .divbox {
      display: inline-flex;
    }
  </style>
</head>
<h1><%= "북마크 삭제" %></h1>
</br>
<a href="../index.jsp">홈</a> |
<a href="../history.jsp">위치 히스토리 목록</a> |
<a href="../save.jsp">Open API 와이파이 정보 가져오기</a>|
<a href="../bookmark/bookmarkShow.jsp">북마크 보기</a>|
<a href="../bookmark/bookmarkGroup.jsp">북마크 그룹 관리</a>
</br>
<%
    request.setCharacterEncoding("utf-8");
    int bookmarkId = Integer.parseInt(request.getParameter("ID"));
    BookmarkService service = new BookmarkService();
    List<ResponseBookmark> bookmarkList = service.showOnlyBookmark(bookmarkId);
  %>


<body>
북마크를 삭제하시겠습니까?
<table>
  <thead>
  <tr bgcolor="#04AA6D">
    <th><font color="white">북마크 이름</font></th>
    <th><font color="white">와이파이명</font></th>
    <th><font color="white">등록일자</font></th>
  </tr>
  </thead>
  <tbody>
  <tr>
      <% for(ResponseBookmark bookmarkLists : bookmarkList) { %>
  <tr>
    <td><%= bookmarkLists.getBOOKMARK_NAME()%></td >
    <td><%= bookmarkLists.getWIFI_NO() %> </td>
    <td><%= bookmarkLists.getCREATED_TIME()%> </td>
  <td>
    <form method="post" action="bookmarkDeleteOk.jsp">
      <input type="hidden" name="bookmarkId" value="<%= bookmarkLists.getID() %>">
      <input type="submit" value="삭제">
    </form>
  </td>
  </tr>
  <% }%>
  </tr>


  </tbody>
</table>
</body>
</html>
