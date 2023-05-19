package com.claudiocarige.mscartoes.infra.repository;

import com.claudiocarige.mscartoes.domain.CardPersonal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardPersonalRepository extends JpaRepository<CardPersonal, Long> {
    List<CardPersonal> findByIncomeLessThanEqual(Long income);
}
