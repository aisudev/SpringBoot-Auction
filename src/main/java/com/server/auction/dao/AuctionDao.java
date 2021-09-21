package com.server.auction.dao;

import com.server.auction.entity.Auction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AuctionDao {
    Integer getAuctionSize();
    Page<Auction> getAuctions(Integer pageSize, Integer page);
    Auction getAuction(Long id);
    Auction save(Auction auction);

    Page<Auction> getAuctionLessThanEqual(Float amount, Pageable page);
}
