package com.etimokhov.clients.repository;

import com.etimokhov.clients.model.Citizenship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitizenshipRepository extends JpaRepository<Citizenship, Long> {
}
