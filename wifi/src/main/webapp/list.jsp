<%@ page import="com.example.wifi.dto.response.ResponseWifi" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.wifi.service.WifiService" %>
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
<%--<h1><%= "와이파이 정보 구하기" %>--%>
</h1>
</br>
<%--    아직 index.jsp--%>
<a href="index.jsp">홈</a> |
<a href="index.jsp">위치 히스토리 목록</a> |
<a href="save.jsp">Open API 와이파이 정보 가져오기</a>
</br>

<div class="divbox">
<%--    아직 index.jsp--%>
    <form action="index.jsp" method="post">
        LAT : <input type="text" id="lat" , name="lat"> ,
        LNT : <input type="text" id="lnt" , name="lnt">
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

                console.log("lat : " + latitude);
                console.log("lnt : " + longitude);
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
<%--    <%--%>
<%--        // getWifi20()--%>
<%--    List<ResponseWifi> responseWifi20 = WifiService.showWifi();--%>
<%--    for (ResponseWifi responseWifi : responseWifi20) {--%>
<%--    System.out.println("responseWifi 리스트" + responseWifi);--%>
<%--    }--%>
<%--    for (ResponseWifi responseWifi : responseWifi20) {--%>
<%--    out.write("<tr>");--%>
<%--    out.write("<td>" + responseWifi.getDistance() + "</td>");--%>
<%--    out.write("<td>" + responseWifi.getManageNum() + "</td>");--%>
<%--    out.write("<td>" + responseWifi.getRegion() + "</td>");--%>
<%--    out.write("<td>" + responseWifi.getWifiName() + "</td>");--%>
<%--    out.write("<td>" + responseWifi.getRoadAddress() + "</td>");--%>
<%--    out.write("<td>" + responseWifi.getDetailedAddress() + "</td>");--%>
<%--    out.write("<td>" + responseWifi.getFloor() + "</td>");--%>
<%--    out.write("<td>" + responseWifi.getInstallationType() + "</td>");--%>
<%--    out.write("<td>" + responseWifi.getOrganization() + "</td>");--%>
<%--    out.write("<td>" + responseWifi.getClassifiedService() + "</td>");--%>
<%--    out.write("<td>" + responseWifi.getNetworkType() + "</td>");--%>
<%--    out.write("<td>" + responseWifi.getYearOfInstall() + "</td>");--%>
<%--    out.write("<td>" + responseWifi.getInOrOut() + "</td>");--%>
<%--    out.write("<td>" + responseWifi.getConnEnvironment() + "</td>");--%>
<%--    out.write("<td>" + responseWifi.getLAT() + "</td>");--%>
<%--    out.write("<td>" + responseWifi.getLNT() + "</td>");--%>
<%--    out.write("<td>" + responseWifi.getWorkTime() + "</td>");--%>
<%--    out.write("</tr>");--%>
<%--}--%>
<%--%>--%>
</tr>
</body>
</html>