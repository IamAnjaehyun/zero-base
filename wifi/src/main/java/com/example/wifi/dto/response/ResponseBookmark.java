package com.example.wifi.dto.response;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode()
public class ResponseBookmark {
    int ID ;
    String LIST_NAME;
    String BOOKMARK_NAME;
    String WIFI_NO;
    Timestamp CREATED_TIME;
}
