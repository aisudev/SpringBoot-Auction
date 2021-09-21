package com.server.auction.controller;

import com.server.auction.entity.Auction;
import com.server.auction.services.AuctionService;
import com.server.auction.utils.LabMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuctionController {
    @Autowired
    AuctionService auctionService;

    @GetMapping("auction")
    ResponseEntity<?>getAuctionList(
            @RequestParam(value = "pageSize", required = false) Integer pageSize,
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "amount", required = false)Float amount
    ){
        page = page == null?1:page;
        pageSize = pageSize == null?3:pageSize;
        Page<Auction> output = auctionService.getAuctions(pageSize, page-1);
        if(amount != null){
            output = auctionService.getAuctionLessThanEqual(amount, page, pageSize);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-total-count", String.valueOf(output.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getAuctionDTO(output.getContent()), headers, HttpStatus.OK);
    }
}
