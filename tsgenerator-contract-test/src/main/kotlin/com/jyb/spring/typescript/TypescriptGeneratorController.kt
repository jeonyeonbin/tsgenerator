package com.jyb.spring.typescript

import generator.SpringTsGenerator
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TypescriptGeneratorController(
    private val springTsGenerator: SpringTsGenerator = SpringTsGenerator("com.jyb.spring")
) {

    @GetMapping("/api/v1/typescript")
    fun typescriptGenerate(): String =
        springTsGenerator.makeTsString()
}