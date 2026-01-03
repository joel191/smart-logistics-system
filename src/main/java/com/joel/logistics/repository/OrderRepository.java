package com.joel.logistics.repository;

import com.joel.logistics.order.Order;
import com.joel.logistics.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCustomer(User customer);
}
