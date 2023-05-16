package com.claudiocarige.microclient.infra.repository;

import com.claudiocarige.microclient.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
