package org.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.entity.Paste;

public interface PasteRepository extends JpaRepository<Paste, Long> {

}