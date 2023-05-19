package com.claudiocarige.mscartoes.infra.repository;

import com.claudiocarige.mscartoes.domain.CardClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardClientRepository extends JpaRepository<CardClient, Long> {
}
