package com.server.auction.services;

import com.server.auction.dao.AuctionDao;
import com.server.auction.dao.ItemDao;
import com.server.auction.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceDB implements ItemService{
    @Autowired
    ItemDao itemDao;

    @Override
    public List<Item> getAllItems() {
        return itemDao.getItem(Pageable.unpaged()).getContent();
    }

    @Override
    public Page<Item> getItem(Integer pageSize, Integer page) {
        return itemDao.getItem(PageRequest.of(page, pageSize));
    }

    @Override
    public Page<Item> getItemByDescription(String description, Integer page, Integer pageSize) {
        return itemDao.getItemByDescription(description, PageRequest.of(page, pageSize));
    }

    @Override
    public Page<Item> getItemByType(String type, Integer page, Integer pageSize) {
        return itemDao.getItemByType(type, PageRequest.of(page, pageSize));
    }

    @Override
    public Page<Item> getItemByDescriptionOrType(String description, String type, Integer page, Integer pageSize) {
        return itemDao.getItemByDescriptionOrType(description, type, PageRequest.of(page, pageSize));
    }
}
