package com.server.auction.services;

import com.server.auction.entity.Item;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ItemService {
    List<Item> getAllItems();
    Page<Item> getItem(Integer pageSize, Integer page);
    Page<Item> getItemByDescription(String description, Integer page, Integer pageSize);
    Page<Item> getItemByType(String type, Integer page, Integer pageSize);
    Page<Item> getItemByDescriptionOrType(String description, String type, Integer page, Integer pageSize);

}
