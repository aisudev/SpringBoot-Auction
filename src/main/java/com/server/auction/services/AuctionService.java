package com.server.auction.services;

import com.server.auction.entity.Auction;
import org.springframework.data.domain.Page;

public interface AuctionService {
    Integer getAuctionSize();
    Page<Auction> getAuctions(Integer pageSize, Integer page);
    Auction getAuction(Long id);
    Auction save(Auction auction);
    Page<Auction> getAuctionLessThanEqual(Float amount, Integer page, Integer pageSize);
}
