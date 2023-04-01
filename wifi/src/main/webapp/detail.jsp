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
  <style>
    .divbox {
      display: inline-flex;
    }
  </style>
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
  BookmarkService bookmarkService = new BookmarkService();
  List<ResponseBookmarkList> bookmarkLists = bookmarkService.showBookmarkList(); // bookmarkService에서 bookmarklist 테이블에서 name 값을 가져오는 메소드
  request.setAttribute("nameList", bookmarkLists);
%>
<%
  // selectbox에서 선택한 bookmarklist 정보를 가져온다.
  String selectedBookmarkList = request.getParameter("listName");

// 내가 띄운 데이터의 getX_SWIFI_MGR_NO을 가져온다.
  String xSwifiMgrNo = request.getParameter("MGR_NO");

  PreparedStatement pstmt = null;
  Connection conn = null;
  request.setCharacterEncoding("utf-8");
  if (selectedBookmarkList != null && xSwifiMgrNo!=null) {
// bookmark 테이블에 데이터를 추가한다.
    try {
      Class.forName("org.sqlite.JDBC");
      // 데이터베이스 파일 경로
      String url = "jdbc:sqlite:C:/sqllite/test.db";
      // 데이터베이스 연결
      conn = DriverManager.getConnection(url);

      // SQL query 작성
      String sql = "INSERT INTO bookmark (BOOKMARK_NO, WIFI_NO, CREATED_TIME) VALUES (?, ? ,?)";
      // Prepare statement 생성
      conn.prepareStatement(sql);
      pstmt.setString(1, selectedBookmarkList);
      pstmt.setString(2, xSwifiMgrNo);
      pstmt.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

      // Execute query
      pstmt.executeUpdate();

      // Clean-up
      pstmt.close();
      conn.close();

    } catch (SQLException | ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
%>


<select>
  <option value="">북마크 그룹 이름 선택</option>
  <% for(ResponseBookmarkList bookmark : bookmarkLists) { %>
  <option name="listName" id="listName" value="<%= bookmark.getName() %>"><%= bookmark.getName() %></option>
  <% } %>
</select>
<button onclick="location.href='../bookmark/bookmarkShow.jsp'">북마크 추가하기</button>

<form>

</form>
<table>
  <thead>
  <tr bgcolor="#04AA6D">
    <th><font color="white">거리(km)</font></th>
    <th><font color="white">관리번호</font></th>
    <th><font color="white">자치구</font></th>
    <th><font color="white">와이파이명</font></th>
    <th><font color="white">도로명주소</font></th>
    <th><font color="white">상세주소</font></th>
    <th><font color="white">설치위치(층)</font></th>
    <th><font color="white">설치유형</font></th>
    <th><font color="white">설치기관</font></th>
    <th><font color="white">서비스구분</font></th>
    <th><font color="white">망종류</font></th>
    <th><font color="white">설치년도</font></th>
    <th><font color="white">실내외구분</font></th>
    <th><font color="white">WIFI접속환경</font></th>
    <th><font color="white">X좌표</font></th>
    <th><font color="white">Y좌표</font></th>
    <th><font color="white">작업일자</font></th>
  </tr>
  </thead>
  <tbody>
  <tr>

      <%
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

      <% for(ResponseWifi responseWifi : resWifi) { %>
  <tr>
    <td><%= responseWifi.getDistance()%>km</td >
    <td id="MGR_NO"><%= responseWifi.getX_SWIFI_MGR_NO()%></td >
    <td><%= responseWifi.getX_SWIFI_WRDOFC() %> </td>
    <td><%= responseWifi.getX_SWIFI_MAIN_NM() %> </td>
    <td><%= responseWifi.getX_SWIFI_ADRES1() %> </td>
    <td><%= responseWifi.getX_SWIFI_ADRES2() %> </td>
    <td><%= responseWifi.getX_SWIFI_INSTL_FLOOR() %> </td>
    <td><%= responseWifi.getX_SWIFI_INSTL_TY() %> </td>
    <td><%= responseWifi.getX_SWIFI_INSTL_MBY() %> </td>
    <td><%= responseWifi.getX_SWIFI_SVC_SE() %> </td>
    <td><%= responseWifi.getX_SWIFI_CMCWR() %> </td>
    <td><%= responseWifi.getX_SWIFI_CNSTC_YEAR() %> </td>
    <td><%= responseWifi.getX_SWIFI_INOUT_DOOR() %> </td>
    <td><%= responseWifi.getX_SWIFI_REMARS3() %> </td>
    <td><%= responseWifi.getLAT() %> </td>
    <td><%= responseWifi.getLNT() %> </td>
    <td><%= responseWifi.getWORK_DTTM() %> </td>
  </tr>
  <% }%>
  </tr>
  </tbody>
</table>

</body>
</html>