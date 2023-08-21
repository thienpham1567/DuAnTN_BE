package shoesShop.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import shoesShop.common.Brand.Brand;
import shoesShop.common.Order.Order;
//import shoesShop.common.Cart.CartService;
//import shoesShop.common.CartItem.CartItemService;
import shoesShop.common.Order.OrderService;
//import shoesShop.common.OrderLine.OrderLine;
//import shoesShop.common.OrderLine.OrderLineService;
import shoesShop.common.Product.Product;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {	
	@Autowired
	OrderService orderService;
	

	@GetMapping
	public ResponseEntity<Collection<Order>> retrieveAll(){
		Collection<Order> order = orderService.retrieveAll();
		return new ResponseEntity<Collection<Order>>(order, HttpStatus.OK); 
	}
	
	@GetMapping("/byuserid")
	public ResponseEntity<Collection<Order>> retrieveAll(@RequestParam(name = "userId", required = false) Integer userId){
		Collection<Order> order = orderService.retrieveOrder(userId);
		return new ResponseEntity<Collection<Order>>(order, HttpStatus.OK); 
	}
	
	@GetMapping("/bycartid")
	public ResponseEntity<Order> retrieveOrder(@RequestParam(name = "cartId", required = false) String cartId) throws Exception {
		System.out.print(cartId);
		Order order = orderService.retrieveOne(cartId);
		if (order != null) {
			return new ResponseEntity<Order>(order, HttpStatus.OK);
		}
		return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
	}
	
//	@PutMapping("/{orderId}")
//    public ResponseEntity<Order> updateOrderStatus(@RequestBody Order order, @PathVariable("orderId") String orderId, BindingResult result) throws Exception{
//		if (order == null || result.hasErrors())
//			return new ResponseEntity<Order>(HttpStatus.BAD_REQUEST);
//		
//		Order updatedOrder = this.orderService.update(order, orderId);
//
//		return updatedOrder != null
//				? new ResponseEntity<Order>(updatedOrder, HttpStatus.OK)
//				: new ResponseEntity<Order>(HttpStatus.BAD_REQUEST);
//    }
	
	
//	@PutMapping("{id}/status")
//	public ResponseEntity<Order> updateStatus(@PathVariable String id, @RequestParam String newStatus) {
//	    Order updatedOrder = this.orderService.updateStatus(id, newStatus);
//	    return updatedOrder != null
//	            ? new ResponseEntity<Order>(updatedOrder, HttpStatus.OK)
//	            : new ResponseEntity<Order>(HttpStatus.BAD_REQUEST);
//	}

	
	@PutMapping("{orderid}")
	public ResponseEntity<Order> update(@RequestBody Order order,@PathVariable("orderid") String orderid, BindingResult result) throws Exception {
		if (order == null || result.hasErrors()) {
			return new ResponseEntity<Order>(HttpStatus.BAD_REQUEST);
		}
		
		Order updatedOrder = this.orderService.update(order, orderid);

		return updatedOrder != null
				? new ResponseEntity<Order>(updatedOrder, HttpStatus.OK)
				: new ResponseEntity<Order>(HttpStatus.BAD_REQUEST);
	}
	
	
//	@PutMapping("{id}")
//    public ResponseEntity<Order> updateOrderStatus(@PathVariable String orderId, @RequestParam("orderstatus") String orderstatus
//    ) {
//        try {
//            Order existingOrder = orderService.retrieveOne(orderId);
//            System.out.println(existingOrder);
//            if (existingOrder != null) {
//                // Cập nhật trạng thái đơn hàng bằng cách gọi service updateOrderStatus
//                Order updatedOrder = orderService.updateOrderStatus(existingOrder, orderId, orderstatus);
//                return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
//            } else {
//            	System.out.println("1");
//                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            }
//        } catch (ClassNotFoundException ex) {
//            // Xử lý ngoại lệ khi không tìm thấy đơn hàng
//        	System.out.println("2");
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        } catch (Exception ex) {
//            // Xử lý các ngoại lệ khác nếu có
//        	System.out.println("3");
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

}
