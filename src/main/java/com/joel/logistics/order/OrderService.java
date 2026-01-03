package com.joel.logistics.order;

import com.joel.logistics.dto.CreateOrderRequest;
import com.joel.logistics.dto.UpdateOrderStatusRequest;
import com.joel.logistics.order.Order;
import com.joel.logistics.order.OrderStatus;
import com.joel.logistics.repository.OrderRepository;
import com.joel.logistics.repository.UserRepository;
import com.joel.logistics.user.User;

import org.apache.coyote.BadRequestException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderService(OrderRepository orderRepository,
            UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    public Order createOrder(CreateOrderRequest request) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();

        User customer = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Order order = new Order();
        order.setCustomer(customer);
        order.setTotalAmount(request.getTotalAmount());
        order.setStatus(OrderStatus.CREATED);

        return orderRepository.save(order);
    }

    private void validateStatusTransition(OrderStatus current, OrderStatus next) throws BadRequestException {
        if (current == OrderStatus.CREATED && next != OrderStatus.ASSIGNED)
            throw new BadRequestException("Order must be ASSIGNED first");

        if (current == OrderStatus.ASSIGNED && next != OrderStatus.PICKED)
            throw new BadRequestException("Order must be PICKED next");

        if (current == OrderStatus.PICKED && next != OrderStatus.DELIVERED)
            throw new BadRequestException("Order must be DELIVERED next");

        if (current == OrderStatus.DELIVERED)
            throw new BadRequestException("Order already completed");
    }

    public Order updateStatus(Long orderId, UpdateOrderStatusRequest request) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setStatus(OrderStatus.valueOf(request.getStatus()));

        return orderRepository.save(order);
    }

    public List<Order> getOrdersForCurrentUser() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (user.getRole().getName().equals("ADMIN")) {
            return orderRepository.findAll();
        }

        return orderRepository.findByCustomer(user);
    }
}
