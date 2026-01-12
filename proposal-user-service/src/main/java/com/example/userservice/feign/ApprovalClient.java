package com.example.userservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "proposal-approval-service")
public interface ApprovalClient {

    @GetMapping("/approval/test")
    String testApproval();
}