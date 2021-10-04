package com.jyb.spring.finder

import com.jyb.spring.example.controller.ExampleController
import com.jyb.spring.typescript.TypescriptGeneratorController
import finder.SpringBeanFinder
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SpringBeanFinderTest {

    @Test
    fun `spring bean finder whithin spring boot webmvc`() {
        val finder = SpringBeanFinder(listOf("com.jyb.spring"))

        assertThat(
            finder.controllerBeans
        ).isEqualTo(
            listOf(ExampleController::class.java, TypescriptGeneratorController::class.java)
        )
    }
}