package option

import me.ntrrgc.tsGenerator.ClassTransformer
import transformer.TypescriptIgnoreTransformer
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import kotlin.reflect.KClass

open class TypescriptGeneratorOption {

    fun makeClassTransformers(): List<ClassTransformer> =
        listOf(TypescriptIgnoreTransformer)

    fun makeIgnoreSuperClazzes(): Set<KClass<*>> =
        setOf()

    fun makeMappings(): Map<KClass<*>, String> =
        mapOf(
            LocalDateTime::class to "string",
            LocalDate::class to "string",
            LocalTime::class to "string",
            BigDecimal::class to "string",
        )
}