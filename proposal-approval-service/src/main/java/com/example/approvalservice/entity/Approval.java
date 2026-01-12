package com.example.approvalservice.entity;
import jakarta.persistence.*;
import java.util.*;

@Entity @Table(name="approvals")
public class Approval {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable=false) private UUID userId;
    @Column(nullable=false, length=200) private String assetName;
    @Column(nullable=false, length=20)  private String status = "DRAFT";
    @Temporal(TemporalType.TIMESTAMP) @Column(nullable=false)
    private Date createdAt = new Date();
    // getters/setters...
}