package com.example.wifi.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
@Getter
@Setter
public class RequestWifi {
    String X_SWIFI_MGR_NO;      //"ARI00001" 관리번호
    String X_SWIFI_WRDOFC;      //"서대문구" 자치구
    String X_SWIFI_MAIN_NM;     //"상수도사업본부" 와이파이명
    String X_SWIFI_ADRES1;      //"서소문로 51" 도로명주소
    String X_SWIFI_ADRES2;      //"본관 1F" 상세주소
    String X_SWIFI_INSTL_FLOOR; //"" 설치위치(층)
    String X_SWIFI_INSTL_TY;    //"7-1. 공공 - 행정" 설치유형
    String X_SWIFI_INSTL_MBY;   //"서울시(AP)" 설치기관
    String X_SWIFI_SVC_SE;      //"공공WiFi" 서비스구분
    String X_SWIFI_CMCWR;       //"자가망_수도사업소망" 망종류
    int X_SWIFI_CNSTC_YEAR;     //"2019" 설치년도
    String X_SWIFI_INOUT_DOOR;  //"실내" 실내외구분
    String X_SWIFI_REMARS3;     //"" wifi접속환경
    Float LAT;                  //"126.96675" Y좌표
    Float LNT;                  //"37/561924" X좌표
    Timestamp WORK_DTTM;        //"2023-03-20 10:58:16.0" 작업일자

    @Builder
    public RequestWifi(String x_SWIFI_MGR_NO, String x_SWIFI_WRDOFC, String x_SWIFI_MAIN_NM, String x_SWIFI_ADRES1, String x_SWIFI_ADRES2, String x_SWIFI_INSTL_FLOOR, String x_SWIFI_INSTL_TY, String x_SWIFI_INSTL_MBY, String x_SWIFI_SVC_SE, String x_SWIFI_CMCWR, int x_SWIFI_CNSTC_YEAR, String x_SWIFI_INOUT_DOOR, String x_SWIFI_REMARS3, Float LAT, Float LNT, Timestamp WORK_DTTM) {
        X_SWIFI_MGR_NO = x_SWIFI_MGR_NO;
        X_SWIFI_WRDOFC = x_SWIFI_WRDOFC;
        X_SWIFI_MAIN_NM = x_SWIFI_MAIN_NM;
        X_SWIFI_ADRES1 = x_SWIFI_ADRES1;
        X_SWIFI_ADRES2 = x_SWIFI_ADRES2;
        X_SWIFI_INSTL_FLOOR = x_SWIFI_INSTL_FLOOR;
        X_SWIFI_INSTL_TY = x_SWIFI_INSTL_TY;
        X_SWIFI_INSTL_MBY = x_SWIFI_INSTL_MBY;
        X_SWIFI_SVC_SE = x_SWIFI_SVC_SE;
        X_SWIFI_CMCWR = x_SWIFI_CMCWR;
        X_SWIFI_CNSTC_YEAR = x_SWIFI_CNSTC_YEAR;
        X_SWIFI_INOUT_DOOR = x_SWIFI_INOUT_DOOR;
        X_SWIFI_REMARS3 = x_SWIFI_REMARS3;
        this.LAT = LAT;
        this.LNT = LNT;
        this.WORK_DTTM = WORK_DTTM;
    }
}
