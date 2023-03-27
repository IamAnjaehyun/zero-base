package com.example.wifi.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
public class RequestHistory {
    Float LAT ;
    Float LNT;
    Timestamp CREATED_TIME = Timestamp.valueOf(LocalDateTime.now());
}
