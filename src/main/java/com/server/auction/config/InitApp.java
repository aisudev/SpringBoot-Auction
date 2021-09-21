package com.server.auction.config;

import com.server.auction.entity.Auction;
import com.server.auction.entity.Item;
import com.server.auction.repository.AuctionRepo;
import com.server.auction.repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Component
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    AuctionRepo auctionRepo;
    @Autowired
    ItemRepo itemRepo;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Item item1, item2, item3, item4, item5;
        item1 = itemRepo.save(Item.builder().name("one").description("one is gas").type("gas").build());
        item2 = itemRepo.save(Item.builder().name("two").description("two is solid").type("solid").build());
        item3 = itemRepo.save(Item.builder().name("three").description("three is solid").type("solid").build());
        item4 = itemRepo.save(Item.builder().name("four").description("four is liquid").type("liquid").build());
        item5 = itemRepo.save(Item.builder().name("five").description("five is gas").type("gas").build());

        Auction auc;
        auc = auctionRepo.save(Auction.builder().amount(1f).date(new Date()).build());
        auc.setItem(item1);
        item1.getAuctions().add(auc);
        auc = auctionRepo.save(Auction.builder().amount(2f).date(new Date()).build());
        auc.setItem(item1);
        item1.getAuctions().add(auc);
        auc = auctionRepo.save(Auction.builder().amount(3f).date(new Date()).build());
        auc.setItem(item1);
        item1.getAuctions().add(auc);

        auc = auctionRepo.save(Auction.builder().amount(1f).date(new Date()).build());
        auc.setItem(item2);
        item1.getAuctions().add(auc);
        auc = auctionRepo.save(Auction.builder().amount(2f).date(new Date()).build());
        auc.setItem(item2);
        item1.getAuctions().add(auc);
        auc = auctionRepo.save(Auction.builder().amount(3f).date(new Date()).build());
        auc.setItem(item2);
        item1.getAuctions().add(auc);

        auc = auctionRepo.save(Auction.builder().amount(1f).date(new Date()).build());
        auc.setItem(item3);
        item1.getAuctions().add(auc);
        auc = auctionRepo.save(Auction.builder().amount(2f).date(new Date()).build());
        auc.setItem(item3);
        item1.getAuctions().add(auc);
        auc = auctionRepo.save(Auction.builder().amount(3f).date(new Date()).build());
        auc.setItem(item3);
        item1.getAuctions().add(auc);

        auc = auctionRepo.save(Auction.builder().amount(1f).date(new Date()).build());
        auc.setItem(item4);
        item1.getAuctions().add(auc);
        auc = auctionRepo.save(Auction.builder().amount(2f).date(new Date()).build());
        auc.setItem(item4);
        item1.getAuctions().add(auc);
        auc = auctionRepo.save(Auction.builder().amount(3f).date(new Date()).build());
        auc.setItem(item4);
        item1.getAuctions().add(auc);

        auc = auctionRepo.save(Auction.builder().amount(1f).date(new Date()).build());
        auc.setItem(item5);
        item1.getAuctions().add(auc);
        auc = auctionRepo.save(Auction.builder().amount(2f).date(new Date()).build());
        auc.setItem(item5);
        item1.getAuctions().add(auc);
        auc = auctionRepo.save(Auction.builder().amount(3f).date(new Date()).build());
        auc.setItem(item5);
        item1.getAuctions().add(auc);
    }
}
