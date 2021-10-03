package transformer

import annotation.TypescriptIgnore
import me.ntrrgc.tsGenerator.ClassTransformer
import kotlin.reflect.KClass
import kotlin.reflect.KProperty
import kotlin.reflect.full.findAnnotation

object TypescriptIgnoreTransformer: ClassTransformer {

    override fun transformPropertyList(properties: List<KProperty<*>>, klass: KClass<*>): List<KProperty<*>> {
        return properties.filter {
            it.findAnnotation<TypescriptIgnore>() == null
        }
    }
}