package scanner

import annotation.TypescriptOuter
import org.reflections.Reflections
import kotlin.reflect.KClass

class TypescriptOuterClazzScanner(packageNames: List<String>) : KtClazzScanner(packageNames) {
    override fun getKtClasses(): Iterable<KClass<*>> {
        return packageNames
            .map {
                findKotlinClazz(packageName = it)
            }.flatten()
    }

    private fun findKotlinClazz(packageName: String): List<KClass<*>> {
        return Reflections(packageName)
            .getTypesAnnotatedWith(TypescriptOuter::class.java)
            .map { clazz -> clazz.kotlin }
    }
}