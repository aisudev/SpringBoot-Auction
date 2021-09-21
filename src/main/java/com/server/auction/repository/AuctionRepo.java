package com.server.auction.repository;

import com.server.auction.entity.Auction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuctionRepo extends JpaRepository<Auction, Long> {
    List<Auction> findAll();
    Page<Auction> findByAmountLessThanEqual(Float amount, Pageable page);
}
