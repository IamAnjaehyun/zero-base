<%@ page import="com.example.wifi.service.BookmarkService" %>
<%@ page import="com.example.wifi.dto.response.ResponseBookmark" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Jaehyun</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
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
    BookmarkService service = new BookmarkService();
    ResponseBookmark responseBookmark = new ResponseBookmark();
    List<ResponseBookmark> bookmarkList = service.showBookmark();
%>
<body>
<%
    String deleteBookmarkId = request.getParameter("bookmarkId");
    if(deleteBookmarkId != null) {
        service.deleteBookmark(Integer.parseInt(deleteBookmarkId));
    }
%>
<script>
    alert("북마크가 삭제되었습니다.");
    location.href = "bookmarkDelete.jsp";
</script>

북마크를 삭제하시겠습니까?
<table>
    <thead>
    <tr bgcolor="#04AA6D">
        <th><font color="white">북마크 이름</font></th>
        <th><font color="white">와이파이명</font></th>
        <th><font color="white">등록일자</font></th>
        <th><font color="white">삭제</font></th>
    </tr>
    </thead>
    <tbody>
    <% for(ResponseBookmark bookmarkLists : bookmarkList) { %>
    <tr>
        <td id="MGR_NO"><%= bookmarkLists.getBOOKMARK_NAME()%></td>
        <td><%= bookmarkLists.getWIFI_NO() %></td>
        <td><%= bookmarkLists.getCREATED_TIME()%></td>
        <td>
            <form method="post" action="bookmarkDelete.jsp">
                <input type="hidden" name="bookmarkId" value="<%= bookmarkLists.getID() %>">
                <input type="submit" value="삭제">
            </form>
        </td>
    </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>
