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
    int id;
    String name;
    int orderNum;
    Timestamp created = Timestamp.valueOf(LocalDateTime.now());
    Timestamp fix;
}
