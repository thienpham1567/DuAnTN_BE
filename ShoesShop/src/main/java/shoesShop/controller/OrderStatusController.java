package shoesShop.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shoesShop.model.OrderStatus;
import shoesShop.service.OrderStatusService;

@RestController
@RequestMapping("/order-statuses")
public class OrderStatusController {

    @Autowired
    private OrderStatusService orderStatusService;

    @GetMapping("")
    public ResponseEntity<Collection<OrderStatus>> retrieveAll() {
        Collection<OrderStatus> orderStatuses = this.orderStatusService.retrieveAll();
        return new ResponseEntity<>(orderStatuses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderStatus> retrieveOne(@PathVariable("id") Integer id) {
        OrderStatus orderStatus = this.orderStatusService.retrieveOne(id);
        if (orderStatus == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(orderStatus, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<OrderStatus> create(@RequestBody OrderStatus orderStatus) {
        OrderStatus createdOrderStatus = this.orderStatusService.create(orderStatus);
        return new ResponseEntity<>(createdOrderStatus, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderStatus> update(@RequestBody OrderStatus orderStatus, @PathVariable("id") Integer id) {
        OrderStatus updatedOrderStatus = this.orderStatusService.update(orderStatus, id);
        if (updatedOrderStatus == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedOrderStatus, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Integer id) {
        boolean deleted = this.orderStatusService.delete(id);
        if (!deleted) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
