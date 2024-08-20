package org.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.entity.Paste;

import java.util.Optional;

public interface PasteRepository extends JpaRepository<Paste, Long> {

    Optional<Paste> findByMinioUrl(String url);
}
