package shoesShop.controller;

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
import org.springframework.web.bind.annotation.RestController;

import shoesShop.common.OrderLine.OrderLine;
import shoesShop.common.OrderLine.OrderLineService;
import shoesShop.common.UserRole.UserRole;

@RestController
@RequestMapping("api/v1/orderlines")
public class OrderLineController {
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
