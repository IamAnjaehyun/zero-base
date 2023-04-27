package zerobase.weather.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;

@Service
public class DiaryService {
    @Value("${openweathermap.key}")
    private String apiKey;

    public void createDiary(LocalDate date, String text) {
        //open weather map 에서 데이터 받아오기
        getWeatherString();
        //받아온 날씨 데이터 파싱하기
        //db에 저장하기
    }

    private String getWeatherString() {
        String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=seoul&appid=" + apiKey;

        System.out.println(apiUrl);
        return "";
//        try {
//            URL url = new URL(apiUrl);
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("GET");
//            int responseCode = connection.getResponseCode();
//            BufferedReader br;
//            if (responseCode == 200) {
//                br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//            } else {
//                br = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
//            }
//            String inputLine;
//            StringBuilder response = new StringBuilder();
//            while ((inputLine = br.readLine()) != null){
//                response.append(inputLine);
//            }
//            br.close();
//            return response.toString();
//        } catch (Exception e) {
//            return "failed to get response";
//        }
    }
}
