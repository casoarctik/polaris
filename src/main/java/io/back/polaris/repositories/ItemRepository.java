package io.back.polaris.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.back.polaris.models.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
    
}
