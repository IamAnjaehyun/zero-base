package com.example.wifi.service;

import com.example.wifi.dto.request.RequestBookmarkList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookmarkService {
    public void addBookMarkList(RequestBookmarkList requestBookmarkList) {
        PreparedStatement pstmt;
        Connection conn = null;

        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:C:/sqllite/test.db";
            conn = DriverManager.getConnection(url);

            // 테이블 생성 후 데이터 삽입
            String sql = "insert into BOOKMARKLIST (NAME, ID) values (?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, requestBookmarkList.getName());
            pstmt.setInt(2, requestBookmarkList.getId());
            pstmt.executeUpdate();
            System.out.println(pstmt);
            pstmt.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
