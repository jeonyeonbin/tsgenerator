package com.jyb.spring.example.domain

data class Order(
    val order: String,
    val status: OrderStatus? = OrderStatus.PREPARED,
    val name: String,
    val id: Long,
    val orderItem: OrderItem,
)