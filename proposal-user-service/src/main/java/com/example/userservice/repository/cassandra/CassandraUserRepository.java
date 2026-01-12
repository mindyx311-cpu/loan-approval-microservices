package com.example.userservice.repository.cassandra;

import com.example.userservice.entity.CassandraUser;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CassandraUserRepository extends CassandraRepository<CassandraUser, UUID> {
}