package scanner

import org.springframework.web.bind.annotation.*
import java.lang.reflect.Method


object MappingAnnotationChecker {
    private val REQUEST_MAPPING_ANNOTATIONS =
        listOf(
            RequestMapping::class,
            GetMapping::class,
            PostMapping::class,
            DeleteMapping::class,
            PutMapping::class
        )
            .map {
                it.java
            }

    fun isCandidate(method: Method): Boolean {
        return REQUEST_MAPPING_ANNOTATIONS.any { annotation -> method.isAnnotationPresent(annotation)}
    }
}