package com.example.wifi.service;

import com.example.wifi.dto.request.RequestBookmarkList;
import com.example.wifi.dto.response.ResponseBookmarkList;
import com.example.wifi.dto.response.ResponseHistory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookmarkService {
//  bookmarkListAdd.jsp 안으로 이동
//    public void addBookMarkList(RequestBookmarkList requestBookmarkList) {
//        PreparedStatement pstmt;
//        Connection conn = null;
//
//        try {
//            Class.forName("org.sqlite.JDBC");
//            String url = "jdbc:sqlite:C:/sqllite/test.db";
//            conn = DriverManager.getConnection(url);
//
//            // 테이블 생성 후 데이터 삽입
//            String sql = "insert into BOOKMARKLIST (NAME, ID) values (?, ?)";
//            pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1, requestBookmarkList.getName());
//            pstmt.setInt(2, requestBookmarkList.getId());
//            pstmt.executeUpdate();
//            System.out.println(pstmt);
//            pstmt.close();
//        } catch (SQLException | ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }
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

}
