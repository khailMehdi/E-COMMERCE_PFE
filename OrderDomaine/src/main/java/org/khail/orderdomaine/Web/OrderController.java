package org.khail.orderdomaine.Web;

import org.khail.orderdomaine.Entitie.Order;
import org.khail.orderdomaine.Service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    private final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping("/orders")
    public List<Order> getOrder(){
        return orderService.getAllOrders();
    }
    @GetMapping("/orders/{id}")
    public Order getOrderById(@PathVariable int id){
        return orderService.getOrderById(id);
    }
    @PostMapping("/orders")
    public Order addOrder(@PathVariable Order order){
        return orderService.addOrder(order);
    }
    @DeleteMapping("/orders/{id}")
    public void deleteOrder(@PathVariable int id){
        orderService.deleteOrder(id);
    }
}
