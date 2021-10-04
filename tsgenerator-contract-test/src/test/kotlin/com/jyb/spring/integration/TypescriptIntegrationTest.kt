package com.jyb.spring.integration

import com.jyb.spring.typescript.TypescriptGeneratorController
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@ExtendWith(SpringExtension::class)
@WebMvcTest(TypescriptGeneratorController::class)
class TypescriptIntegrationTest {
    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun `typescript integeration test`() {

        val expected =
            """declare namespace ServerSpec {
    export interface OrderItem {
        productId: number;
        productName: string;
    }

    export type OrderStatus = "PREPARED" | "ORDERED" | "COMPLETED";

    export interface Order {
        id: number;
        name: string;
        order: string;
        orderItem: OrderItem;
        status: OrderStatus | null;
    }}"""

        this.mockMvc.perform(get("/api/v1/typescript"))
            .andDo(print()).andExpect(status().isOk)
            .andExpect(
                content().string(expected + "\n")
            )
            .andReturn()
    }
}