package com.example.wifi;

import com.example.wifi.dto.request.RequestWifi;
import com.example.wifi.service.WifiService;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;

public class ApiExplorer {

    public Integer saveWifi() throws IOException {
        WifiService wifiService = new WifiService();

        int totalCount = 0;
        int startIndex = 1;

        while (true) {
            /*URL*/

            String urlBuilder = "http://openapi.seoul.go.kr:8088" + "/" + URLEncoder.encode("인증키!!!", "UTF-8") + /*인증키 (sample사용시에는 호출시 제한됩니다.)*/
                    "/" + URLEncoder.encode("json", "UTF-8") + /*요청파일타입 (xml,xmlf,xls,json) */
                    "/" + URLEncoder.encode("TbPublicWifiInfo", "UTF-8") +

                    /*요청시작위치 (한 번에 천개까지 가능)*/
                    "/" + URLEncoder.encode(String.valueOf(startIndex), "UTF-8") +
                    "/" + URLEncoder.encode(String.valueOf(startIndex + 999), "UTF-8");
            URL url = new URL(urlBuilder);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/json; charset=UTF-8");
            System.out.println("Response code: " + conn.getResponseCode()); /* 연결 자체에 대한 확인이 필요하므로 추가합니다.*/


            BufferedReader rd;
            // 서비스코드가 정상이면 200~300사이의 숫자가 나옵니다.
            if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
            } else {
                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(), StandardCharsets.UTF_8));
            }
            System.out.println(rd);
            //1000개씩 넣음
            StringBuilder responseBuilder = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                responseBuilder.append(line);
            }

            rd.close();
            conn.disconnect();


            // 손수 자른곳
            String[] wifiJSON = responseBuilder.toString().split("row");
            if (!(wifiJSON.length == 2)) { //헤더만있고 바디 없으면 다받아온거임 break
                break;
            }
            //헤더 제거해서 json형태로 자름
            String strWifiJSON = wifiJSON[1].substring(2, wifiJSON[1].length() - 2);
            //파싱
            JsonArray jsonArray = JsonParser.parseString(strWifiJSON).getAsJsonArray();

            // 1000개를 1개씩
            for (int j = 0; j < jsonArray.size(); j++) {
                totalCount += 1; // 인스턴스 개수

                // JsonArray -> JsonObject
                // [] 제거  -> {"":"", ..., "":""}
                JsonObject object = (JsonObject) jsonArray.get(j);

                // JsonObject -> RequestWifi
                // 키명 -> 필드명

                RequestWifi requestWifi = RequestWifi.builder()
                        .X_SWIFI_MGR_NO(object.get("X_SWIFI_MGR_NO").getAsString())
                        .X_SWIFI_WRDOFC(object.get("X_SWIFI_WRDOFC").getAsString())
                        .X_SWIFI_MAIN_NM(object.get("X_SWIFI_MAIN_NM").getAsString())
                        .X_SWIFI_ADRES1(object.get("X_SWIFI_ADRES1").getAsString())
                        .X_SWIFI_ADRES2(object.get("X_SWIFI_ADRES2").getAsString())
                        .X_SWIFI_INSTL_FLOOR(object.get("X_SWIFI_INSTL_FLOOR").getAsString())
                        .X_SWIFI_INSTL_TY(object.get("X_SWIFI_INSTL_TY").getAsString())
                        .X_SWIFI_INSTL_MBY(object.get("X_SWIFI_INSTL_MBY").getAsString())
                        .X_SWIFI_SVC_SE(object.get("X_SWIFI_SVC_SE").getAsString())
                        .X_SWIFI_CMCWR(object.get("X_SWIFI_CMCWR").getAsString())
                        .X_SWIFI_CNSTC_YEAR(object.get("X_SWIFI_CNSTC_YEAR").getAsString())
                        .X_SWIFI_INOUT_DOOR(object.get("X_SWIFI_INOUT_DOOR").getAsString())
                        .X_SWIFI_REMARS3(object.get("X_SWIFI_REMARS3").getAsString())
                        .LAT(object.get("LNT").getAsFloat())
                        .LNT(object.get("LAT").getAsFloat())
                        .WORK_DTTM(Timestamp.valueOf(object.get("WORK_DTTM").getAsString()))
                        .build();
//                 디비에 저장
                wifiService.saveWifi(requestWifi);
            }
            startIndex += 1000;

        }

        return totalCount;
    }
}
