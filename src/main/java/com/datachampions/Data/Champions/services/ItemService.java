package com.datachampions.Data.Champions.services;

import com.datachampions.Data.Champions.entities.item.Item;
import com.datachampions.Data.Champions.repositories.ItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Transactional
    public void saveAll(List<Item> items) {
        itemRepository.saveAll(items);
    }
}
