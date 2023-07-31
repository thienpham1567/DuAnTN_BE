package shoesShop.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import shoesShop.common.Order.Order;
//import shoesShop.common.Cart.CartService;
//import shoesShop.common.CartItem.CartItemService;
import shoesShop.common.Order.OrderService;
//import shoesShop.common.OrderLine.OrderLine;
//import shoesShop.common.OrderLine.OrderLineService;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {	
	@Autowired
	OrderService orderService;
	

	@GetMapping
	public ResponseEntity<Collection<Order>> retrieveAll(){
		Collection<Order> products = orderService.retrieveAll();
		return new ResponseEntity<Collection<Order>>(products, HttpStatus.OK); 
	}
	
	@GetMapping("/byuserid")
	public ResponseEntity<Collection<Order>> retrieveAll(@RequestParam(name = "userId", required = false) Integer userId){
		Collection<Order> products = orderService.retrieveAll(userId);
		return new ResponseEntity<Collection<Order>>(products, HttpStatus.OK); 
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Order> retrieveOne(@PathVariable("id") Integer id) throws Exception {
		System.out.print(id);
		Order order = orderService.retrieveOne(id);
		if (order != null) {
			return new ResponseEntity<Order>(order, HttpStatus.OK);
		}
		return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
	}
	

}
