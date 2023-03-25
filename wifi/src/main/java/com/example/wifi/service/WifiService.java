package com.example.wifi.service;

import com.example.wifi.dto.request.RequestWifi;
import com.example.wifi.dto.response.ResponseWifi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class WifiService {
    public void saveWifi(RequestWifi requestWifi) {
        PreparedStatement pstmt;
        Connection conn = null;

        try {
            Class.forName("org.sqlite.JDBC");
            // 데이터베이스 파일 경로
            String url = "jdbc:sqlite:C:/sqllite/test.db";
            // 데이터베이스 연결
            conn = DriverManager.getConnection(url);
//            System.out.println("SQLite 데이터베이스에 연결되었습니다.");

            String sql = "insert into WIFI(X_SWIFI_MGR_NO, X_SWIFI_WRDOFC, X_SWIFI_MAIN_NM, X_SWIFI_ADRES1, X_SWIFI_ADRES2, X_SWIFI_INSTL_FLOOR, X_SWIFI_INSTL_TY, X_SWIFI_INSTL_MBY, X_SWIFI_SVC_SE, X_SWIFI_CMCWR, X_SWIFI_CNSTC_YEAR, X_SWIFI_INOUT_DOOR, X_SWIFI_REMARS3, lat, lnt, WORK_DTTM)" +
                    "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, requestWifi.getX_SWIFI_MGR_NO());
            pstmt.setString(2, requestWifi.getX_SWIFI_WRDOFC());
            pstmt.setString(3, requestWifi.getX_SWIFI_MAIN_NM());
            pstmt.setString(4, requestWifi.getX_SWIFI_ADRES1());
            pstmt.setString(5, requestWifi.getX_SWIFI_ADRES2());
            pstmt.setString(6, requestWifi.getX_SWIFI_INSTL_FLOOR());
            pstmt.setString(7, requestWifi.getX_SWIFI_INSTL_TY());
            pstmt.setString(8, requestWifi.getX_SWIFI_INSTL_MBY());
            pstmt.setString(9, requestWifi.getX_SWIFI_SVC_SE());
            pstmt.setString(10, requestWifi.getX_SWIFI_CMCWR());
            pstmt.setString(11, requestWifi.getX_SWIFI_CNSTC_YEAR());
            pstmt.setString(12, requestWifi.getX_SWIFI_INOUT_DOOR());
            pstmt.setString(13, requestWifi.getX_SWIFI_REMARS3());
            pstmt.setFloat(14, requestWifi.getLAT());
            pstmt.setFloat(15, requestWifi.getLNT());
            pstmt.setTimestamp(16, requestWifi.getWORK_DTTM());

            pstmt.executeUpdate();

        } catch (ClassNotFoundException e) {
            System.out.println("드라이버를 찾을 수 없습니다.");
        } catch (SQLException e) {
           e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("SQLite 데이터베이스를 닫을 수 없습니다.");
            }
        }
    }


    public void deleteWifi() {

    }

    public void deleteAllWifi() {

    }

    public static double calculateDistance(Float x1, Float y1, Float x2, Float y2) {
        double x = Math.pow(Math.abs(x2 - x1), 2);
        double y = Math.pow(Math.abs(y2 - y1), 2);

        return Math.sqrt(x + y);
    }

//    public List<ResponseWifi> showWifi() {
//
//    }
}