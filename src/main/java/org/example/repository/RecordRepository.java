package org.example.repository;

import org.example.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecordRepository extends JpaRepository<Record, Long> {

    Optional<Record> findRecordByUrl(String url);

    boolean existsByUrl(String url);
}