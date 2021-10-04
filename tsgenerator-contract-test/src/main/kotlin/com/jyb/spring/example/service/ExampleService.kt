package com.jyb.spring.example.service

import com.jyb.spring.example.domain.Order
import com.jyb.spring.example.domain.OrderItem
import org.springframework.stereotype.Service

@Service
class ExampleService {
    fun serveOrder(): Order =
        Order(
            order = "orderName",
            name = "testOrder",
            id = 1,
            orderItem = OrderItem(
                productId = 1,
                productName = "test",
            )
        )
}