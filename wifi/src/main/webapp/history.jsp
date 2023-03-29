<%@ page import="com.example.wifi.service.WifiService" %>
<%@ page import="com.example.wifi.dto.response.ResponseHistory" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<html>
<head>
    <title>Title</title>
</head>
<%
    WifiService service = new WifiService();
    ResponseHistory responseHistory = new ResponseHistory();
    List<ResponseHistory> historyList = service.showHistory();
%>
<body>
<h1><%= "위치 히스토리 목록" %>
</h1>
</br>
<a href="index.jsp">홈</a> |
<a href="history.jsp">위치 히스토리 목록</a> |
<a href="save.jsp">Open API 와이파이 정보 가져오기</a>|
<a href="bookmark/bookmarkShow.jsp">북마크 보기</a>|
<a href="bookmark/bookmarkGroup.jsp">북마크 그룹 관리</a>
</br>

<table>
    <thead>
    <tr bgcolor="#04AA6D">
        <th><font color="white">ID</font></th>
        <th><font color="white">X좌표</font></th>
        <th><font color="white">Y좌표</font></th>
        <th><font color="white">조회일자</font></th>
        <th><font color="white">비고</font></th>
    </tr>
    </thead>
    <tbody>
    <% for (ResponseHistory history : historyList) { %>
    <tr>
        <td><%= history.getID() %></td>
        <td><%= history.getLAT() %></td>
        <td><%= history.getLNT() %></td>
        <td><%= history.getCREATED_TIME() %></td>
        <td><button onclick="deleteHistory('<%= history.getID() %>')">삭제</button></td>
    </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>
<script>
    function deleteHistory(ID) {
        if (confirm("정말로 삭제하시겠습니까?")) {
            $.ajax({
                url: "history.jsp",
                data: {id: ID},
                success: function () {
                    location.reload();
                }
            });
        }
    }
</script>

<%
    String id = request.getParameter("id");
    if (id != null) {
        try {
            service.deleteHistory(Integer.parseInt(id));
            response.setStatus(204);
            return;
        } finally {
            return;
        }
    }
%>