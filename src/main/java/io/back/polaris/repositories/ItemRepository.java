package io.back.polaris.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.back.polaris.models.database.generics.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
    
}
