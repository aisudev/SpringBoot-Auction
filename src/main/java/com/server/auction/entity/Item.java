package com.server.auction.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String name;
    String type;
    String description;
    @OneToMany(mappedBy = "item")
    @Builder.Default
    List<Auction> auctions = new ArrayList<>();
}
