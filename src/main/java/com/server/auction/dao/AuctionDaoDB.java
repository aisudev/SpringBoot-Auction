package com.server.auction.dao;

import com.server.auction.entity.Auction;
import com.server.auction.repository.AuctionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@Profile("db")
public class AuctionDaoDB implements AuctionDao{
    @Autowired
    AuctionRepo auctionRepo;

    @Override
    public Integer getAuctionSize() {
        return Math.toIntExact(auctionRepo.count());
    }

    @Override
    public Page<Auction> getAuctions(Integer pageSize, Integer page) {
        return auctionRepo.findAll(PageRequest.of(page, pageSize));
    }

    @Override
    public Auction getAuction(Long id) {
        return auctionRepo.findById(id).orElse(null);
    }

    @Override
    public Auction save(Auction auction) {
        return auctionRepo.save(auction);
    }

    @Override
    public Page<Auction> getAuctionLessThanEqual(Float amount, Pageable page) {
        return auctionRepo.findByAmountLessThanEqual(amount, page);
    }
}
