package io.back.polaris.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.back.polaris.models.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    
}
