package com.claudiocarige.mscartoes.infra.repository;

import com.claudiocarige.mscartoes.domain.CardPersonal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardPersonalRepository extends JpaRepository<CardPersonal, Long> {
}
