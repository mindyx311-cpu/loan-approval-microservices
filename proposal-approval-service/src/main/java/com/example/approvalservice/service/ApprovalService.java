package com.example.approvalservice.service;

import com.example.approvalservice.dto.ApprovalEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApprovalService {

    private final ApprovalEventPublisher approvalEventPublisher;

    public void approveForm(Long userId, Long formId, String reason) {
        // 1. 业务逻辑：更新 MySQL 状态，比如保存审批结果
        // approvalRepository.save(...);

        // 2. 发布事件到 SQS
        ApprovalEvent event = new ApprovalEvent();
        event.setUserId(userId);
        event.setFormId(formId);
        event.setStatus("APPROVED");
        event.setReason(reason);

        approvalEventPublisher.publish(event);
    }
}
