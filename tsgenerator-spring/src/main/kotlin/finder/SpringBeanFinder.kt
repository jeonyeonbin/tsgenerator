package finder

import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider
import org.springframework.core.type.filter.AnnotationTypeFilter
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RestController

class SpringBeanFinder(packageNames: List<String>) {
    val controllerBeans: List<Class<*>>

    init {
        val classPathProvider = ClassPathScanningCandidateComponentProvider(false)
            .also {
                it.addExcludeFilter(AnnotationTypeFilter(RestController::class.java))
                it.addExcludeFilter(AnnotationTypeFilter(Controller::class.java))
            }

        controllerBeans =
            packageNames
                .map {
                    classPathProvider.findCandidateComponents(it)
                }.let {
                    getClazzWithController(it)
                }
    }

    private fun getClazzWithController(beans: List<Set<BeanDefinition>>): List<Class<*>> =
        beans.flatten()
            .map {
                Class.forName(it.beanClassName)
            }
}