package shoesShop.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoesShop.converter.OrderStatusConverter;
import shoesShop.entity.DbOrderStatus;
import shoesShop.model.OrderStatus;
import shoesShop.repository.IOrderStatusRepository;

@Service
public class OrderStatusService extends RecordManager<OrderStatus> {

    @Autowired
    private IOrderStatusRepository orderStatusRepo;

    private OrderStatusConverter converter = new OrderStatusConverter();

    @Override
    public Collection<OrderStatus> retrieveAll() {
        Collection<OrderStatus> orderStatuses = this.orderStatusRepo.findAll().stream()
                .map(dbOrderStatus -> this.converter.convertDbToModel(dbOrderStatus)).collect(Collectors.toList());
        return orderStatuses;
    }

    @Override
    public OrderStatus retrieveOne(Integer id) {
        OrderStatus orderStatus = this.orderStatusRepo.findById(id).map(dbOrderStatus -> this.converter.convertDbToModel(dbOrderStatus)).orElse(null);
        return orderStatus;
    }

    @Override
    public OrderStatus create(OrderStatus orderStatus) {
        DbOrderStatus dbOrderStatus = this.converter.convertModelToDb(orderStatus);
        DbOrderStatus createdOrderStatus = this.orderStatusRepo.save(dbOrderStatus);
        return this.converter.convertDbToModel(createdOrderStatus);
    }

    @Override
    public OrderStatus update(OrderStatus orderStatus, Integer id) {
        DbOrderStatus updateOrderStatus = this.converter.convertModelToDb(orderStatus);
        DbOrderStatus dbOrderStatus = this.orderStatusRepo.findById(id).orElse(null);
        if (dbOrderStatus != null) {
            this.converter.combine(dbOrderStatus, updateOrderStatus);
            DbOrderStatus updateDbOrderStatus = this.orderStatusRepo.save(dbOrderStatus);
            return this.converter.convertDbToModel(updateDbOrderStatus);
        }
        return null;
    }

    @Override
    public Boolean delete(Integer id) {
        if (this.orderStatusRepo.existsById(id)) {
            this.orderStatusRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
