package org.khail.orderdomaine.Service;

import org.khail.orderdomaine.Entitie.Order;

import java.util.List;

public interface OrderService {
    public List<Order> getAllOrders();
    public Order getOrderById(int id);
   // public Order addOrder(Order order);
    public Order createOrder(Order order);
    public void deleteOrder(int id);


}
