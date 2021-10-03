package transformer

import finder.MethodParameterFinder
import finder.MethodReturnFinder
import java.lang.reflect.Method

private val FILTERING_CLAZZ_NAME = listOf("void", "java", "long", "org.springframework")
class MethodTransformer(private val methods: List<Method>) {

    fun getClazzNames(): List<String> =
        listOf(MethodReturnFinder(), MethodParameterFinder())
            .asSequence()
            .map {
                methods.map {
                        method ->
                    it.findGenericWrappedClazz(method)
                }.flatten()
            }
            .flatten()
            .filter { !FILTERING_CLAZZ_NAME.any { clazzName -> it.startsWith(clazzName)}}
            .toSortedSet()
            .toList()
}