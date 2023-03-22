<%@ page import="com.example.wifi.ApiExplorer" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jaehyun wifi</title>
    <meta charset="UTF-8">
</head>
<body>
<script>

</script>
<%
    ApiExplorer apiExplorer = new ApiExplorer();
    Integer numOfWifi = 1;
%>
<p></p>
<div style="text-align: center"><h1><%=numOfWifi%>개의 WIFI 정보를 정상적으로 저장하였습니다.</h1></div>
<p></p>
<div style="text-align: center"><a href="index.jsp">홈으로 가기</a></div>
</body>
</html>
