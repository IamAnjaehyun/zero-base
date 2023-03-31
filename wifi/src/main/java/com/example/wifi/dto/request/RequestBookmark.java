package com.example.wifi.dto.request;

import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode()
public class RequestBookmark {
    int ID ;
    String BOOKMARK_NAME;
    String WIFI_NO;
    String BOOKMARK_NO;
    Timestamp CREATED_TIME;
    Timestamp FIX_TIME;
}
