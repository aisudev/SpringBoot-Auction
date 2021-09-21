package com.server.auction.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {
    Long id;
    String name;
    String type;
    String description;
    List<ItemAuctionDTO> auctions = new ArrayList<>();
}
