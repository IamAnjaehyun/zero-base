package com.example.wifi.service;

import com.example.wifi.dto.request.RequestHistory;
import com.example.wifi.dto.request.RequestWifi;
import com.example.wifi.dto.response.ResponseHistory;
import com.example.wifi.dto.response.ResponseWifi;

import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
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

    public void saveHistory(RequestHistory requestHistory) {
        PreparedStatement pstmt = null;
        Connection conn = null;

        try {
            Class.forName("org.sqlite.JDBC");
            // 데이터베이스 파일 경로
            String url = "jdbc:sqlite:C:/sqllite/test.db";
            // 데이터베이스 연결
            conn = DriverManager.getConnection(url);

            String sql = "insert into HISTORY(LAT, LNT, CREATED_TIME) " +
                    "values (?, ?, ?); ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setFloat(1, requestHistory.getLAT());
            pstmt.setFloat(2, requestHistory.getLNT());
            pstmt.setTimestamp(3, requestHistory.getCREATED_TIME());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("[SQL Error : " + e.getMessage() + "]");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<ResponseHistory> showHistory() {
        List<ResponseHistory> responseHistories = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName("org.sqlite.JDBC");
            // 데이터베이스 파일 경로
            String url = "jdbc:sqlite:C:/sqllite/test.db";
            // 데이터베이스 연결
            conn = DriverManager.getConnection(url);
            String sql = "select * from HISTORY order by ID asc";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                ResponseHistory responseHistory = ResponseHistory.builder()
                        .ID(rs.getInt("ID"))
                        .LAT(rs.getFloat("LAT"))
                        .LNT(rs.getFloat("LNT"))
                        .CREATED_TIME(rs.getTimestamp("CREATED_TIME"))
                        .build();
                responseHistories.add(responseHistory);
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return responseHistories;
    }

    public void deleteHistory(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:C:/sqllite/test.db";
            conn = DriverManager.getConnection(url);

            String sql = "delete from HISTORY where ID = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<ResponseWifi> getNearbyLocations(float lat, float lnt) throws SQLException {
        List<ResponseWifi> result = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName("org.sqlite.JDBC");
            // 데이터베이스 파일 경로
            String url = "jdbc:sqlite:C:/sqllite/test.db";
            // 데이터베이스 연결
            conn = DriverManager.getConnection(url);
            String sql = "SELECT * FROM WIFI WHERE lat BETWEEN ? AND ? AND lnt BETWEEN ? AND ? ORDER BY SQRT(POWER(ABS(lat - ?), 2) + POWER(ABS(lnt - ?), 2)) LIMIT 20";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            pstmt.setDouble(1, lat - 0.1);
            pstmt.setDouble(2, lat + 0.1);
            pstmt.setDouble(3, lnt - 0.1);
            pstmt.setDouble(4, lnt + 0.1);
            pstmt.setDouble(5, lat);
            pstmt.setDouble(6, lnt);

            while (rs.next()) {
                float lat2 = rs.getFloat("lat");
                float lng2 = rs.getFloat("lng");

                ResponseWifi responseWifi = ResponseWifi.builder()
                        .X_SWIFI_MGR_NO(rs.getString("X_SWIFI_MGR_NO"))
                        .X_SWIFI_WRDOFC(rs.getString("X_SWIFI_WRDOFC"))
                        .X_SWIFI_MAIN_NM(rs.getString("X_SWIFI_MAIN_NM"))
                        .X_SWIFI_ADRES1(rs.getString("X_SWIFI_ADRES1"))
                        .X_SWIFI_ADRES2(rs.getString("X_SWIFI_ADRES2"))
                        .X_SWIFI_INSTL_FLOOR(rs.getString("X_SWIFI_INSTL_FLOOR"))
                        .X_SWIFI_INSTL_TY(rs.getString("X_SWIFI_INSTL_TY"))
                        .X_SWIFI_INSTL_MBY(rs.getString("X_SWIFI_INSTL_MBY"))
                        .X_SWIFI_SVC_SE(rs.getString("X_SWIFI_SVC_SE"))
                        .X_SWIFI_CMCWR(rs.getString("X_SWIFI_CMCWR"))
                        .X_SWIFI_CNSTC_YEAR(rs.getString("X_SWIFI_CNSTC_YEAR"))
                        .X_SWIFI_INOUT_DOOR(rs.getString("X_SWIFI_INOUT_DOOR"))
                        .X_SWIFI_REMARS3(rs.getString("X_SWIFI_REMARS3"))
                        .LAT(rs.getFloat("LAT"))
                        .LNT(rs.getFloat("LNT"))
                        .WORK_DTTM(Timestamp.valueOf(String.valueOf(rs.getTimestamp("WORK_DTTM").getTime())))
                        .build();

                result.add(responseWifi);
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public List<ResponseWifi> showWifi(float myLat, float myLnt) throws SQLException {
        List<ResponseWifi> show20 = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName("org.sqlite.JDBC");
            // 데이터베이스 파일 경로
            String url = "jdbc:sqlite:C:/sqllite/test.db";
            // 데이터베이스 연결
            conn = DriverManager.getConnection(url);
//            String sql = "SELECT *, 6371 * 2 * ASIN(SQRT(POWER(SIN((RADIANS(LAT) - RADIANS(?)) / 2), 2) + COS(RADIANS(?)) * COS(RADIANS(LAT)) * POWER(SIN((RADIANS(LNT) - RADIANS(?)) / 2), 2))) AS distance FROM WIFI ORDER BY distance asc LIMIT 0, 20";
            String sql = "SELECT *, 6371 * 2 * ASIN(SQRT(POWER(SIN(((LAT - ?) * PI() / 180) / 2), 2) + COS(? * PI() / 180) * COS((LAT * PI() / 180)) * POWER(SIN(((LNT - ?) * PI() / 180) / 2), 2))) AS distance FROM WIFI ORDER BY distance LIMIT 0, 20";
            pstmt = conn.prepareStatement(sql);
            pstmt.setFloat(1, myLat);
            pstmt.setFloat(2, myLat);
            pstmt.setFloat(3, myLnt);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                float distance = rs.getFloat("distance");
                distance = Math.round(distance * 1000.0f) / 1000.0f; // 반올림
                ResponseWifi responseWifi = ResponseWifi.builder()
                        .distance(distance)
                        .X_SWIFI_MGR_NO(rs.getString("X_SWIFI_MGR_NO"))
                        .X_SWIFI_WRDOFC(rs.getString("X_SWIFI_WRDOFC"))
                        .X_SWIFI_MAIN_NM(rs.getString("X_SWIFI_MAIN_NM"))
                        .X_SWIFI_ADRES1(rs.getString("X_SWIFI_ADRES1"))
                        .X_SWIFI_ADRES2(rs.getString("X_SWIFI_ADRES2"))
                        .X_SWIFI_INSTL_FLOOR(rs.getString("X_SWIFI_INSTL_FLOOR"))
                        .X_SWIFI_INSTL_TY(rs.getString("X_SWIFI_INSTL_TY"))
                        .X_SWIFI_INSTL_MBY(rs.getString("X_SWIFI_INSTL_MBY"))
                        .X_SWIFI_SVC_SE(rs.getString("X_SWIFI_SVC_SE"))
                        .X_SWIFI_CMCWR(rs.getString("X_SWIFI_CMCWR"))
                        .X_SWIFI_CNSTC_YEAR(rs.getString("X_SWIFI_CNSTC_YEAR"))
                        .X_SWIFI_INOUT_DOOR(rs.getString("X_SWIFI_INOUT_DOOR"))
                        .X_SWIFI_REMARS3(rs.getString("X_SWIFI_REMARS3"))
                        .LAT(rs.getFloat("LAT"))
                        .LNT(rs.getFloat("LNT"))
                        .WORK_DTTM(rs.getTimestamp("WORK_DTTM"))
                        .build();

                show20.add(responseWifi);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return show20;
    }

    public List<ResponseWifi> showDetail(String mgrNo, float distance) throws SQLException {
        List<ResponseWifi> showDetail = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName("org.sqlite.JDBC");
            // 데이터베이스 파일 경로
            String url = "jdbc:sqlite:C:/sqllite/test.db";
            // 데이터베이스 연결
            conn = DriverManager.getConnection(url);
            String sql = "SELECT * FROM WIFI WHERE X_SWIFI_MGR_NO = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, mgrNo); // x_swifi_main_nm 파라미터 설정
            rs = pstmt.executeQuery();

            while (rs.next()) {
                ResponseWifi responseWifi = ResponseWifi.builder()
                        .distance(distance)
                        .X_SWIFI_MGR_NO(rs.getString("X_SWIFI_MGR_NO"))
                        .X_SWIFI_WRDOFC(rs.getString("X_SWIFI_WRDOFC"))
                        .X_SWIFI_MAIN_NM(rs.getString("X_SWIFI_MAIN_NM"))
                        .X_SWIFI_ADRES1(rs.getString("X_SWIFI_ADRES1"))
                        .X_SWIFI_ADRES2(rs.getString("X_SWIFI_ADRES2"))
                        .X_SWIFI_INSTL_FLOOR(rs.getString("X_SWIFI_INSTL_FLOOR"))
                        .X_SWIFI_INSTL_TY(rs.getString("X_SWIFI_INSTL_TY"))
                        .X_SWIFI_INSTL_MBY(rs.getString("X_SWIFI_INSTL_MBY"))
                        .X_SWIFI_SVC_SE(rs.getString("X_SWIFI_SVC_SE"))
                        .X_SWIFI_CMCWR(rs.getString("X_SWIFI_CMCWR"))
                        .X_SWIFI_CNSTC_YEAR(rs.getString("X_SWIFI_CNSTC_YEAR"))
                        .X_SWIFI_INOUT_DOOR(rs.getString("X_SWIFI_INOUT_DOOR"))
                        .X_SWIFI_REMARS3(rs.getString("X_SWIFI_REMARS3"))
                        .LAT(rs.getFloat("LAT"))
                        .LNT(rs.getFloat("LNT"))
                        .WORK_DTTM(rs.getTimestamp("WORK_DTTM"))
                        .build();
                showDetail.add(responseWifi);
            }
            return showDetail;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}