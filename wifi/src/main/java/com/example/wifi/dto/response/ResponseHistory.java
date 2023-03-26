package com.example.wifi.dto.response;

import lombok.*;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode()
public class ResponseHistory {
    Integer ID ;
    Float LAT ;
    Float LNT;
    Timestamp CREATED_TIME;
}
