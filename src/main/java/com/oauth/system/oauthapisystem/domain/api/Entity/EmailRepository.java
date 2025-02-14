package com.oauth.system.oauthapisystem.domain.api.Entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmailRepository extends JpaRepository<Email, Long> {

}
