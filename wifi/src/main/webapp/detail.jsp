<%@ page import="com.example.wifi.dto.response.ResponseWifi" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.wifi.service.WifiService" %>
<%@ page import="com.example.wifi.service.BookmarkService" %>
<%@ page import="com.example.wifi.dto.response.ResponseBookmarkList" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JaeHyun</title>
  <link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body>
<h1><%= "와이파이 정보 구하기" %>
</h1>
</br>
<a href="index.jsp">홈</a> |
<a href="history.jsp">위치 히스토리 목록</a> |
<a href="save.jsp">Open API 와이파이 정보 가져오기</a>|
<a href="bookmark/bookmarkShow.jsp">북마크 보기</a>|
<a href="bookmark/bookmarkGroup.jsp">북마크 그룹 관리</a>
</br>
<%
  request.setCharacterEncoding("utf-8");
  BookmarkService bookmarkService = new BookmarkService();
  List<ResponseBookmarkList> bookmarkLists = bookmarkService.showBookmarkList(); // bookmarkService에서 bookmarklist 테이블에서 name 값을 가져오는 메소드
  request.setAttribute("nameList", bookmarkLists);
%>
<%
    request.setCharacterEncoding("utf-8");
    // wifi에 대한 상세 정보를 조회한다.
    WifiService wifiService = new WifiService();
    String mgrNo = request.getParameter("mgrNo");
    List<ResponseWifi> resWifi = null;
    if(request.getParameter("distance") != null){
        try {
            resWifi = wifiService.showDetail(mgrNo,Float.parseFloat(request.getParameter("distance")));
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
%>

<select name="listName" id="listName">
  <option value="">북마크 그룹 이름 선택</option>
  <% for(ResponseBookmarkList bookmark : bookmarkLists) { %>
  <option name="listName" id="listName" value="<%= bookmark.getName() %>"><%= bookmark.getName() %></option>
  <% } %>
</select>
<button onclick="addWifiInfoToBookmark('<%=resWifi.get(0).getX_SWIFI_MGR_NO()%>',document.querySelector('#listName').value)">북마크 추가하기</button>

<form>

</form>
<table>
  <thead>
    <% for(ResponseWifi responseWifi : resWifi) { %>
    <tr><th bgcolor="#04AA6D"><font color="white">거리(km)</font></th>      <td><%= responseWifi.getDistance()%>km</td></tr>
    <tr><th bgcolor="#04AA6D"><font color="white">관리번호</font></th>       <td id="MGR_NO"><%= responseWifi.getX_SWIFI_MGR_NO()%></td></tr>
    <tr><th bgcolor="#04AA6D"><font color="white">자치구</font></th>        <td><%= responseWifi.getX_SWIFI_WRDOFC() %> </td></tr>
    <tr><th bgcolor="#04AA6D" ><font color="white">도로명주소</font></th>     <td><%= responseWifi.getX_SWIFI_ADRES1() %> </td></tr>
    <tr><th bgcolor="#04AA6D"><font color="white">와이파이명</font></th>     <td><%= responseWifi.getX_SWIFI_MAIN_NM() %> </td></tr>
    <tr><th bgcolor="#04AA6D"><font color="white">상세주소</font></th>       <td><%= responseWifi.getX_SWIFI_ADRES2() %> </td></tr>
    <tr><th bgcolor="#04AA6D"><font color="white">설치위치(층)</font></th>   <td><%= responseWifi.getX_SWIFI_INSTL_FLOOR() %> </td></tr>
    <tr><th bgcolor="#04AA6D"><font color="white">설치유형</font></th>      <td><%= responseWifi.getX_SWIFI_INSTL_TY() %> </td></tr>
    <tr><th bgcolor="#04AA6D"><font color="white">설치기관</font></th>      <td><%= responseWifi.getX_SWIFI_INSTL_MBY() %> </td></tr>
    <tr><th bgcolor="#04AA6D"><font color="white">서비스구분</font></th>    <td><%= responseWifi.getX_SWIFI_SVC_SE() %> </td></tr>
    <tr><th bgcolor="#04AA6D"><font color="white">망종류</font></th>       <td><%= responseWifi.getX_SWIFI_CMCWR() %> </td></tr>
    <tr><th bgcolor="#04AA6D"><font color="white">설치년도</font></th>     <td><%= responseWifi.getX_SWIFI_CNSTC_YEAR() %> </td></tr>
    <tr><th bgcolor="#04AA6D"><font color="white">실내외구분</font></th>    <td><%= responseWifi.getX_SWIFI_INOUT_DOOR() %> </td></tr>
    <tr><th bgcolor="#04AA6D"><font color="white">WIFI접속환경</font></th> <td><%= responseWifi.getX_SWIFI_REMARS3() %> </td></tr>
    <tr><th bgcolor="#04AA6D"><font color="white">X좌표</font></th>       <td><%= responseWifi.getLAT() %> </td></tr>
    <tr><th bgcolor="#04AA6D"><font color="white">Y좌표</font></th>       <td><%= responseWifi.getLNT() %> </td></tr>
    <tr><th bgcolor="#04AA6D"><font color="white">작업일자</font></th>     <td><%= responseWifi.getWORK_DTTM() %> </td></tr>
    <% }%>

  </tr>
  </thead>
</table>
<script type="text/javascript">
  function addWifiInfoToBookmark(mgrNo){
      let listName = document.getElementById('listName').value;

      console.log('param check:::' + mgrNo,listName)

      let form = document.createElement('form');
      form.setAttribute("charset","UTF-8");
      form.setAttribute("method","POST");
      <%--form.setAttribute("action",'<%=request.getContextPath()%>/bookmark/bookmarkWifiInfoAdd.jsp')--%>
    form.setAttribute('action', '<%=request.getContextPath()%>/bookmark/bookmarkWifiInfoAdd.jsp');


    let mgrNoInput = document.createElement("input");
      mgrNoInput.setAttribute("type","hidden");
      mgrNoInput.setAttribute("name","mgrNo");
      mgrNoInput.setAttribute("value",mgrNo);

      let listNameInput = document.createElement("input");
      listNameInput.setAttribute("type","hidden");
      listNameInput.setAttribute("name","listName");
      listNameInput.setAttribute("value",listName);

      form.appendChild(mgrNoInput);
      form.appendChild(listNameInput);
      //body에 동적으로 생성한 form 데이터를 추가한다.

      document.body.appendChild(form);
      //전송
      form.submit();
  }

</script>
</body>
</html>