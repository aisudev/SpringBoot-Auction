package com.server.auction.utils;

import com.server.auction.entity.Auction;
import com.server.auction.entity.AuctionDTO;
import com.server.auction.entity.Item;
import com.server.auction.entity.ItemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);
    AuctionDTO getAuctionDTO(Auction auction);
    List<AuctionDTO> getAuctionDTO(List<Auction> auctions);

    ItemDTO getItemDTO(Item item);
    List<ItemDTO> getItemDTO(List<Item> items);
}
