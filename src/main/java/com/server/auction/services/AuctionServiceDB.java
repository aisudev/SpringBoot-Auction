package com.server.auction.services;

import com.server.auction.dao.AuctionDao;
import com.server.auction.dao.ItemDao;
import com.server.auction.entity.Auction;
import com.server.auction.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class AuctionServiceDB implements AuctionService{
    @Autowired
    AuctionDao auctionDao;
    @Autowired
    ItemDao itemDao;

    @Override
    public Integer getAuctionSize() {
        return auctionDao.getAuctionSize();
    }

    @Override
    public Page<Auction> getAuctions(Integer pageSize, Integer page) {
        return auctionDao.getAuctions(pageSize, page);
    }

    @Override
    public Auction getAuction(Long id) {
        return auctionDao.getAuction(id);
    }

    @Override
    public Auction save(Auction auction) {
        Item item = itemDao.findById(auction.getItem().getId()).orElse(null);
        auction.setItem(item);
        item.getAuctions().add(auction);
        return auctionDao.save(auction);
    }

    @Override
    public Page<Auction> getAuctionLessThanEqual(Float amount, Integer page, Integer pageSize) {
        return auctionDao.getAuctionLessThanEqual(amount, PageRequest.of(page, pageSize));
    }
}
