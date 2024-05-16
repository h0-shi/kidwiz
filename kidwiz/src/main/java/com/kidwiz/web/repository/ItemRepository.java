package com.kidwiz.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kidwiz.web.Entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	
	List<Item> findByIdIn(List<Integer> ids);
}
