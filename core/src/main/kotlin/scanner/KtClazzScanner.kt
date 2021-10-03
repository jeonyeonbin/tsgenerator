package scanner

import kotlin.reflect.KClass

abstract class KtClazzScanner(val packageNames: List<String>) {
    abstract fun getKtClasses(): Iterable<KClass<*>>
}