package com.server.auction.repository;

import com.server.auction.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepo extends JpaRepository<Item, Long> {
    List<Item> findAll();

    Page<Item> findByDescriptionContaining(String description, Pageable page);
    Page<Item> findByTypeContaining(String type, Pageable page);
    Page<Item> findByDescriptionContainingOrAndTypeContaining(String description, String type, Pageable page);

}
