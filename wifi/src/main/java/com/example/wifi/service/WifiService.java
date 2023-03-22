package com.example.wifi.service;

import com.example.wifi.dto.ResponseWifi;

import java.util.ArrayList;
import java.util.List;

public class WifiService {
    public void saveWifi(){

    }

    public void deleteWifi(){

    }

    public void deleteAllWifi(){

    }

    public static double calculateDistance(Float x1, Float y1, Float x2, Float y2){
        double x = Math.pow(Math.abs(x2 - x1), 2);
        double y = Math.pow(Math.abs(y2 - y1), 2);

        return Math.sqrt(x + y);
    }

    public List<ResponseWifi> showWifi(){
        List<ResponseWifi> showWifi = new ArrayList<>();

        return showWifi;
    }


}
