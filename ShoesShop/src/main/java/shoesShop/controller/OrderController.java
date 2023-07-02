//package shoesShop.controller;
//
//import java.util.ArrayList;
//import java.util.Collection;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import shoesShop.common.Cart.CartService;
//import shoesShop.common.CartItem.CartItemService;
//import shoesShop.common.Order.OrderService;
//import shoesShop.common.OrderLine.OrderLine;
//import shoesShop.common.OrderLine.OrderLineService;
//
//@RestController
//@RequestMapping("api/v1/orders")
//public class OrderController {	
//	@Autowired
//	OrderService orderService;
//	
//	@Autowired
//	OrderLineService orderLineService;
//	 
//	@Autowired
//	CartService cartService ; 
//	
//	@Autowired
//	CartItemService cartItemService ;
//
//	@GetMapping
//	public ResponseEntity<Collection<OrderLine>> retrieveAll(@RequestParam(name = "productItem", required = false) Integer productItemId,
//			   @RequestParam(name = "order", required = false) String orderId){
//		Collection<OrderLine> orders = new ArrayList<>();
//		if (productItemId != null || orderId != null) {
//			orders = orderLineService.retrieveAll(productItemId,orderId);
//		} else {
//			orders = orderLineService.retrieveAll();
//		}
//		return new ResponseEntity<Collection<OrderLine>>(orders, HttpStatus.OK);
//	}
//	
//	@GetMapping("{id}")
//	public ResponseEntity<OrderLine> retrieveOne(@PathVariable("id") Integer id) {
//		System.out.print(id);
//		OrderLine order = orderLineService.retrieveOne(id);
//		if (order != null) {
//			return new ResponseEntity<OrderLine>(order, HttpStatus.OK);
//		}
//
//		return new ResponseEntity<OrderLine>(HttpStatus.NOT_FOUND);
//	}
//	
//
//}
