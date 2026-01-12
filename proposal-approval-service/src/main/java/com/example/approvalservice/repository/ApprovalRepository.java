package com.example.approvalservice.repository;

import com.example.approvalservice.entity.Approval;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface ApprovalRepository extends JpaRepository<Approval, UUID> {
    List<Approval> findByUserIdOrderByCreatedAtDesc(UUID userId);
}