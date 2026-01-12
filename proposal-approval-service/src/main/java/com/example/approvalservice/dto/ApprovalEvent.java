package com.example.approvalservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApprovalEvent {
    private String eventId;
    private Long userId;
    private Long formId;
    private String status;
    private String reason;
    private Instant timestamp;
}