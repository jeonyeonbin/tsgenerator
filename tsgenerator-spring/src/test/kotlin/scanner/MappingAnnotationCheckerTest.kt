package scanner

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.springframework.web.bind.annotation.*

class MappingAnnotationCheckerTest {
    @ParameterizedTest
    @ValueSource(strings = ["requestMapping", "getMapping", "postMapping", "deleteMapping", "putMapping"])
    fun `mapping annotation check`(methodName: String) {
        val method = this.javaClass.getDeclaredMethod(methodName)

        assertEquals(MappingAnnotationChecker.isCandidate(method), true)
    }

    @Test
    fun `no mapping annotation`() {
        val method = this.javaClass.getDeclaredMethod("noMapping")

        assertEquals(MappingAnnotationChecker.isCandidate(method), false)
    }

    @RequestMapping
    fun requestMapping() {

    }

    @GetMapping
    fun getMapping() {

    }

    @PostMapping
    fun postMapping() {

    }

    @PutMapping
    fun putMapping() {

    }

    @DeleteMapping
    fun deleteMapping() {

    }

    fun noMapping() {

    }
}