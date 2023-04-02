package com.example.wifi.dto.response;

import lombok.*;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode()
public class ResponseBookmarkList {
    int ID;
    int NUM;
    Timestamp CREATED_TIME;
    Timestamp FIXED_TIME;
    String name;
}
