package com.example.logSystem.repository;

import com.example.logSystem.entity.Log;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LogRepository extends MongoRepository<Log, String> {
    Optional<Log> findByUser (String id);
    Optional<Log> findByAction (Enum action);
}
