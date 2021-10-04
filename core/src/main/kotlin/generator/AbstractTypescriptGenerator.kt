package generator

abstract class AbstractTypescriptGenerator {
    abstract val tsModelGenerator: TsModelGenerator

    fun makeTsString(): String =
        tsModelGenerator.generateDefintionText()
}