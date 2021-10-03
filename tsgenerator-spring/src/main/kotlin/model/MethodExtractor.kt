package model

import finder.MethodFinder
import java.lang.reflect.Method

data class MethodExtractor(
    private val methods: List<Method>
) {
    fun findClazzNames(methodFinder: MethodFinder): List<String> =
        methods.map { method ->
            methodFinder.findGenericWrappedClazz(method)
        }.flatten()
}