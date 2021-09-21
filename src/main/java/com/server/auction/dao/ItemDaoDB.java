package com.server.auction.dao;

import com.server.auction.entity.Item;
import com.server.auction.repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Profile("db")
public class ItemDaoDB implements ItemDao{
    @Autowired
    ItemRepo itemRepo;

    @Override
    public Page<Item> getItem(Pageable pageRequest) {
        return itemRepo.findAll(pageRequest);
    }

    @Override
    public Optional<Item> findById(Long id) {
        return itemRepo.findById(id);
    }

    @Override
    public Page<Item> getItemByDescription(String description, Pageable page) {
        return itemRepo.findByDescriptionContaining(description, page);
    }

    @Override
    public Page<Item> getItemByType(String type, Pageable page) {
        return itemRepo.findByTypeContaining(type, page);
    }

    @Override
    public Page<Item> getItemByDescriptionOrType(String description, String type, Pageable page) {
        return itemRepo.findByDescriptionContainingOrAndTypeContaining(description, type, page);
    }
}
