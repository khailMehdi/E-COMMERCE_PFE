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

   /* @Override
    public Order getOrderById(int id) {
        return orderRepository.findById(id).orElse(null);
    } */

    @Override
    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(int id) {
      orderRepository.deleteById(id);
    }
     @Override
    public Order createOrder(Order order) {
        // Vérifie que le client existe
        Customer customer = customerServiceClient.getCustomersById(order.getCustomerId());
        System.out.println(customer);
        // 2. Calculer le totalAmount à partir des lignes de commande (optionnel mais recommandé)
        BigDecimal totalAmount = order.getOrderLines().stream()
                .map(line -> line.getOrder().getTotalAmount().multiply(BigDecimal.valueOf(line.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        order.setTotalAmount(totalAmount);

        // 3. Lier les lignes d'order à l'ordre parent
        order.getOrderLines().forEach(line -> line.setOrder(order));

        // 4. Définir la date de création si besoin (souvent géré par @CreatedDate)
        if (order.getCreatedDate() == null) {
            order.setCreatedDate(LocalDateTime.now());
        }
        return orderRepository.save(order);
    }
}
