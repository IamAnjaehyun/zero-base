package com.example.wifi.service;

import com.example.wifi.dto.response.ResponseBookmark;
import com.example.wifi.dto.response.ResponseBookmarkList;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BookmarkService {
    //북마크 저장시 셀렉트 태그에 나열
    public List<ResponseBookmarkList> showBookmarkList() {
        List<ResponseBookmarkList> responseHistories = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName("org.sqlite.JDBC");
            // 데이터베이스 파일 경로
            String url = "jdbc:sqlite:/Users/jaehyun/Desktop/sqlite/wifi.db";
            // 데이터베이스 연결
            conn = DriverManager.getConnection(url);
            String sql = "select * from BOOKMARKLIST order by ID asc";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                ResponseBookmarkList responseBookmarkList = ResponseBookmarkList.builder()
                        .name(rs.getString("name"))
                        .build();
                responseHistories.add(responseBookmarkList);
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return responseHistories;
    }

    //북마크 그룹페이지에서 호출
    public List<ResponseBookmarkList> showBookmarkGroupList() {
        List<ResponseBookmarkList> responseHistories = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName("org.sqlite.JDBC");
            // 데이터베이스 파일 경로
            String url = "jdbc:sqlite:/Users/jaehyun/Desktop/sqlite/wifi.db";
            // 데이터베이스 연결
            conn = DriverManager.getConnection(url);
            String sql = "select * from BOOKMARKLIST order by ID asc";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                ResponseBookmarkList responseBookmarkList = ResponseBookmarkList.builder()
                        .ID(rs.getInt("ID"))
                        .name(rs.getString("NAME"))
                        .NUM(rs.getInt("NUM"))
                        .CREATED_TIME(rs.getTimestamp("CREATED_TIME"))
                        .FIXED_TIME(rs.getTimestamp("FIXED_TIME"))
                        .build();
                responseHistories.add(responseBookmarkList);
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return responseHistories;
    }

    //저장된 북마크들 호출
    public List<ResponseBookmark> showBookmark() {
        List<ResponseBookmark> responseBookmarks = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName("org.sqlite.JDBC");
            // 데이터베이스 파일 경로
            String url = "jdbc:sqlite:/Users/jaehyun/Desktop/sqlite/wifi.db";

            // 데이터베이스 연결
            conn = DriverManager.getConnection(url);
            String sql = "SELECT b.ID, l.NAME, b.WIFI_NAME, b.CREATED_TIME " +
                    "FROM BOOKMARK b " +
                    "JOIN BOOKMARKLIST l ON b.LIST_ID = l.ID " +
                    "ORDER BY b.ID";

            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                ResponseBookmark responseBookmark = ResponseBookmark.builder()
                        .ID(rs.getInt("ID"))
                        .BOOKMARK_NAME(rs.getString("NAME"))
                        .WIFI_NO(rs.getString("WIFI_NAME"))
                        .CREATED_TIME(rs.getTimestamp("CREATED_TIME"))
                        .build();
                responseBookmarks.add(responseBookmark);
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return responseBookmarks;
    }


    //북마크 수정시 페이지에 정보 나타내기 위함
    public List<ResponseBookmark> showOnlyBookmark(int bookmarkId) {
        List<ResponseBookmark> responseBookmarks = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName("org.sqlite.JDBC");
            // 데이터베이스 파일 경로
            String url = "jdbc:sqlite:/Users/jaehyun/Desktop/sqlite/wifi.db";


            // 데이터베이스 연결
            conn = DriverManager.getConnection(url);
            String sql = "select * from BOOKMARK where ID = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bookmarkId);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                ResponseBookmark responseBookmark = ResponseBookmark.builder()
                        .ID(rs.getInt("ID"))
                        .BOOKMARK_NAME(rs.getString("BOOKMARK_NAME"))
                        .WIFI_NO(rs.getString("WIFI_NAME"))
                        .CREATED_TIME(rs.getTimestamp("CREATED_TIME"))
                        .build();
                responseBookmarks.add(responseBookmark);
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return responseBookmarks;
    }

    //북마크 삭제
    public void deleteBookmark(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:/Users/jaehyun/Desktop/sqlite/wifi.db";

            conn = DriverManager.getConnection(url);

            String sql = "DELETE FROM BOOKMARK where ID = ?";
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

    //북마크 그룹 삭제
    public void deleteBookmarkGroup(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:/Users/jaehyun/Desktop/sqlite/wifi.db";

            conn = DriverManager.getConnection(url);

            String sql = "DELETE FROM BOOKMARKLIST where ID = ?";
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
    //북마크 그룹 수정
    public void fixBookmarkGroup(int id, String name, int num) {
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;

        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:/Users/jaehyun/Desktop/sqlite/wifi.db";

            conn = DriverManager.getConnection(url);

            // BOOKMARKLIST 데이터 수정
            String sql1 = "UPDATE BOOKMARKLIST SET NAME=?, NUM=?, FIXED_TIME=? WHERE ID=?";
            pstmt1 = conn.prepareStatement(sql1);

            pstmt1.setString(1, name);
            pstmt1.setInt(2, num);
            pstmt1.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            pstmt1.setInt(4, id);
            pstmt1.executeUpdate();

//            // BOOKMARK 데이터 수정
//            String sql2 = "UPDATE BOOKMARK SET BOOKMARK_NAME = ? WHERE BOOKMARK_NAME = (SELECT NAME FROM BOOKMARKLIST WHERE ID = ?)";
//
//            pstmt2 = conn.prepareStatement(sql2);
//
//            pstmt2.setString(1, name);
//            pstmt2.setInt(2, id);
//
//            pstmt2.executeUpdate();

            pstmt1.close();
//            pstmt2.close();
            conn.close();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
