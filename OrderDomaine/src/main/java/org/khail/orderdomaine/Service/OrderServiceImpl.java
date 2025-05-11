package org.khail.orderdomaine.Service;

import jakarta.transaction.Transactional;
import org.khail.orderdomaine.Entitie.Order;
import org.khail.orderdomaine.Repository.OrederRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    private OrederRepository orderRepository;
    public OrderServiceImpl(OrederRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(int id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(int id) {
      orderRepository.deleteById(id);
    }
}
