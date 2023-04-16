package shoesShop.controller;

import java.util.ArrayList;
import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import shoesShop.common.Cart.Cart;
import shoesShop.common.Cart.CartService;
import shoesShop.common.CartItem.CartItem;
import shoesShop.common.CartItem.CartItemService;
import shoesShop.common.Order.OrderService;
import shoesShop.common.OrderLine.OrderLine;
import shoesShop.common.OrderLine.OrderLineService;

@RestController
@RequestMapping("api/v1/orderline")
public class OrderLineController extends ApiController {
//	cart = order
//	cartitem = orderline
	@Autowired
	OrderLineService orderLineService;
	
	@GetMapping
	public ResponseEntity<Collection<OrderLine>> retrieveAll() throws Exception {
		Collection<OrderLine> orderLines = orderLineService.retrieveAll();
		
		return new ResponseEntity<Collection<OrderLine>>(orderLines, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<OrderLine> retrieveOne(@PathVariable("id") Integer id) throws Exception {
		
		OrderLine orderLine = orderLineService.retrieveOne(id);
		if (orderLine != null) {
			return new ResponseEntity<OrderLine>(orderLine, HttpStatus.OK);
		}

		return new ResponseEntity<OrderLine>(HttpStatus.NOT_FOUND);
	}
	@PostMapping
	public ResponseEntity<OrderLine> create(@RequestBody @Valid OrderLine orderLine, BindingResult result) throws Exception {
		
		if (orderLine == null || result.hasErrors()) {
			return new ResponseEntity<OrderLine>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<OrderLine>(this.orderLineService.create(orderLine), HttpStatus.CREATED);
	}

}
