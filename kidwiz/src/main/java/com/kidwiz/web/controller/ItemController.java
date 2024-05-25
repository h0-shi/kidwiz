//package com.kidwiz.web.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.kidwiz.web.Entity.Item;
//import com.kidwiz.web.repository.ItemRepository;
//
//@RestController
//public class ItemController {
//
//	@Autowired
//	ItemRepository itemRepository;
//
//	@GetMapping("/api/items")
//	public List<Item> getItems() {
//		List<Item> items = itemRepository.findAll();
//        for (Item item : items) {
//            System.out.println(item.getId()); // 각 Item 객체의 id를 출력
//        }
//		return items;
//	}
//}
