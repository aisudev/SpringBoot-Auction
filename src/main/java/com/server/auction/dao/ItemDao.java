package com.server.auction.dao;

import com.server.auction.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ItemDao {
    Page<Item> getItem(Pageable pageRequest);
    Optional<Item> findById(Long id);

    Page<Item> getItemByDescription(String description, Pageable page);
    Page<Item> getItemByType(String type, Pageable page);
    Page<Item> getItemByDescriptionOrType(String description, String type, Pageable page);
}
