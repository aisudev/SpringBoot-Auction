package com.server.auction.controller;

import com.server.auction.services.ItemService;
import com.server.auction.utils.LabMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
    @Autowired
    ItemService itemService;

    @GetMapping("/item")
    ResponseEntity<?>getItems(
            @RequestParam(value = "desc", required = false) String description,
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "page", required = false)Integer page,
            @RequestParam(value = "pageSize", required = false)Integer pageSize
    ){
        page = page == null?1:page;
        pageSize = pageSize == null?3:pageSize;

        if (type != null && description != null){
            return ResponseEntity.ok(LabMapper.INSTANCE.getItemDTO(itemService.getItemByDescriptionOrType(description, type, page-1, pageSize).getContent()));
        }else if(type != null && description == null){
            return ResponseEntity.ok(LabMapper.INSTANCE.getItemDTO(itemService.getItemByType(type, page-1, pageSize).getContent()));
        }else if(type == null && description != null){
            return ResponseEntity.ok(LabMapper.INSTANCE.getItemDTO(itemService.getItemByDescription(description, page-1, pageSize).getContent()));
        }

        return ResponseEntity.ok(LabMapper.INSTANCE.getItemDTO(itemService.getItem(pageSize, page-1).getContent()));

    }
}
