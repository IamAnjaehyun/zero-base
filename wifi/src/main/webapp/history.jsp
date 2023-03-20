<%--
  Created by IntelliJ IDEA.
  User: ANJH
  Date: 2023-03-20
  Time: 오후 7:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1><%= "와이파이 정보 구하기" %>
</h1>
</br>
<%--    아직 index.jsp--%>
<a href="index.jsp">홈</a> |
<a href="index.jsp">위치 히스토리 목록</a> |
<a href="index.jsp">Open API 와이파이 정보 가져오기</a>
</br>

<table>
  <tr bgcolor="#04AA6D">
    <th><font color="white">ID</font></th>
    <th><font color="white">X좌표</font></th>
    <th><font color="white">Y좌표</font></th>
    <th><font color="white">조회일자</font></th>
    <th><font color="white">비고</font></th>
  </tr>
</table>
</body>
</html>
