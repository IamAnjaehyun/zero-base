package com.example.wifi.dto.request;

import lombok.*;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode()
public class RequestBookmark {
    int ID ;
    String WIFI_NAME;
    String BOOKMARK_NAME;
    Timestamp CREATED_TIME;
}
