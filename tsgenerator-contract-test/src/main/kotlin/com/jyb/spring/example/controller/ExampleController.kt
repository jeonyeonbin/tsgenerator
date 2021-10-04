package com.jyb.spring.example.controller

import com.jyb.spring.example.domain.Order
import com.jyb.spring.example.domain.OrderStatus
import com.jyb.spring.example.service.ExampleService
import org.springframework.web.bind.annotation.*
import java.lang.UnsupportedOperationException

@RestController
class ExampleController(
    private val exampleService: ExampleService
) {
    @GetMapping("/api/test")
    fun orderTestApi(): Order =
        throw UnsupportedOperationException()

    @PostMapping("/api/test")
    fun orderPostTestApi(@RequestBody param: OrderStatus): Order =
        throw UnsupportedOperationException()
}