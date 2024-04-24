package dw.wholesale_company.service;

import dw.wholesale_company.model.Customer;
import dw.wholesale_company.model.Order;
import dw.wholesale_company.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<Order> getOrderByDateAfter(LocalDate date) {
        List<Order> orders = orderRepository.findAll();
        List<Order> orders1 = new ArrayList<>();
        for (int i = 0; i < orders.size(); i++) {
           if (orders.get(i).getOrderDate()== date) {
               orders1.add(orders.get(i));
            }
        }
        return orders1;

//        return orders.stream().filter(a -> a.getOrderDate().compareTo(date) > 0)
//                .collect(Collectors.toList());
    }

    //2020년 4월 9일에 주문한 고객의 모든 정보를 보이시오.
    public List<Customer> getCustomerByOrderDate(LocalDate orderDate) {
        List<Order> orders = orderRepository.findByOrderDate(orderDate);
        return orders.stream().map(order -> order.getCustomer())
                .collect(Collectors.toList());
    }
}
