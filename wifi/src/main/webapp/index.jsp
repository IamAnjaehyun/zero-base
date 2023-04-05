<%@ page import="com.example.wifi.dto.response.ResponseWifi" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.wifi.service.WifiService" %>
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
    WifiService service = new WifiService();
%>
<div class="divbox">
    <form action="list.jsp" method="post">
        LAT : <input type="text" id="lat" , name="lat" value="0.0"> ,
        LNT : <input type="text" id="lnt" , name="lnt" value="0.0">
        <input onclick="getWifi();" type="submit" value="근처 WIFI 정보 보기">
    </form>
        <button onclick="getLocation();">내 위치 가져오기</button>
</div>

<script>
    function getLocation() {
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(function (pos) {
                    var latitude = pos.coords.latitude;
                    var longitude = pos.coords.longitude;

                    document.getElementById("lat").value = latitude;
                    document.getElementById("lnt").value = longitude;
                }
            )
        } else {
            window.alert("현재 위치를 가져올 수 없습니다.")
        }
    }

    function getWifi() {
        let lat = document.getElementById("lat").value;
        let lnt = document.getElementById("lnt").value;
        if (lat === "" || lnt === "") {
            alert("비어있는 값 존재.");
        }else {
            document.forms[0].submit();
        }
    }
</script>

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
</table>
<tr>
</tr>
</body>
</html>