package com.kidwiz.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.kidwiz.web.Entity.Cart;
import com.kidwiz.web.Entity.Item;
import com.kidwiz.web.repository.CartRepository;
import com.kidwiz.web.repository.ItemRepository;
import com.kidwiz.web.service.JwtService;

@RestController
public class CartController {

	@Autowired
    JwtService jwtService;
	
	@Autowired
    ItemRepository itemRepository;
	
	@Autowired
    CartRepository cartRepository;
	
	// 장바구니 출력하기
    @GetMapping("/api/cart/items")
    public ResponseEntity getCartItems(@CookieValue(value = "token", required = false) String token) {
    	
    	System.out.println("장바구니 토큰이 있다?: " + token);

        if (!jwtService.isValid(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        int memberId = jwtService.getId(token);
        List<Cart> carts = cartRepository.findByMemberId(memberId);
        // 카트의 itemId 값들만 list 형태로 출력
        List<Integer> itemIds = carts.stream().map(Cart::getItemId).toList();
        List<Item> items = itemRepository.findByIdIn(itemIds);

        return new ResponseEntity<>(items, HttpStatus.OK);
    }
	
	// 장바구니 담기
    @PostMapping("/api/cart/items/{itemId}")
    public ResponseEntity pushCartItem(
            @PathVariable("itemId") int itemId,
            @CookieValue(value = "token", required = false) String token) {
    	
    	System.out.println("db테스트 토큰이 있다?: " + token);
    	
    	// 토큰값이 유효하지 않으면
        if (!jwtService.isValid(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        int memberId = jwtService.getId(token);
        Cart cart = cartRepository.findByMemberIdAndItemId(memberId, itemId);

        if (cart == null) {
            Cart newCart = new Cart();
            newCart.setMemberId(memberId);
            newCart.setItemId(itemId);
            // 카트에 저장하기
            cartRepository.save(newCart);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    // 장바구니 삭제하기
    @DeleteMapping("/api/cart/items/{itemId}")
    public ResponseEntity removeCartItem(
            @PathVariable("itemId") int itemId,
            @CookieValue(value = "token", required = false) String token) {
    	
    	if (!jwtService.isValid(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
    	
    	int memberId = jwtService.getId(token);
        Cart cart = cartRepository.findByMemberIdAndItemId(memberId, itemId);
    	
    	cartRepository.delete(cart);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
}
