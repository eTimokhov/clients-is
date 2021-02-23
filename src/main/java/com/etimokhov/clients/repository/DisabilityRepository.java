package com.etimokhov.clients.repository;

import com.etimokhov.clients.model.Disability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisabilityRepository extends JpaRepository<Disability, Long> {
}
