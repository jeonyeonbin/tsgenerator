package com.jyb.spring.scanner

import com.jyb.spring.example.domain.Order
import com.jyb.spring.example.domain.OrderStatus
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import scanner.SpringControllerBeanScanner

class SpringControllerBeanScannerTest {

    @Test
    fun `spring controller bean scanner in this module(ExampleController, TypescriptController)`() {
        val ktClazz = SpringControllerBeanScanner(listOf("com.jyb.spring"))
            .getKtClasses()

        assertThat(
            ktClazz
        ).isEqualTo(
            listOf(Order::class, OrderStatus::class)
        )
    }
}