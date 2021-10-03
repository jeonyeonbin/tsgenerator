package scanner

import finder.SpringBeanFinder
import org.springframework.web.bind.annotation.*
import transformer.MethodTransformer
import kotlin.reflect.KClass

class SpringControllerBeanScanner(packageNames: List<String>) : KtClazzScanner(packageNames) {

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

    override fun getKtClasses(): Iterable<KClass<*>> {
        val methods = SpringBeanFinder(packageNames).controllerBeans
            .map {
                it.declaredMethods.toList()
            }
            .flatten()
            .filter {
                REQUEST_MAPPING_ANNOTATIONS.any { annotation -> it.isAnnotationPresent(annotation)}
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