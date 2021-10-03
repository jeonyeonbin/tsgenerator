package scanner

import finder.SpringBeanFinder
import org.springframework.web.bind.annotation.*
import transformer.MethodTransformer
import kotlin.reflect.KClass

class SpringControllerBeanScanner(packageNames: List<String>) : KtClazzScanner(packageNames) {
    override fun getKtClasses(): Iterable<KClass<*>> {
        val methods = SpringBeanFinder(packageNames).controllerBeans
            .map {
                it.declaredMethods.toList()
            }
            .flatten()
            .filter {
                MappingAnnotationChecker.isCandidate(it)
            }

        return MethodTransformer(methods)
            .getClazzNames()
            .mapNotNull {
                try {
                    Class.forName(it).kotlin
                } catch(e: ClassNotFoundException) {
                    null
                }
            }
    }

}