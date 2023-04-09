<%@ page import="com.example.wifi.ApiExplorer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jaehyun wifi</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<%
    ApiExplorer apiExplorer = new ApiExplorer();
    Integer numOfWifi = apiExplorer.saveWifi();
%>

<p></p>
<div style="text-align: center"><h1><%=numOfWifi%>개의 와이파이 데이터를 가져왔습니다.</h1></div>
<p></p>
<div style="text-align: center"><a href="index.jsp">홈으로 가기</a></div>
</body>
</html>
