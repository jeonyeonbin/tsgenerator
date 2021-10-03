package scanner

import generator.TsMessageGenerator
import me.ntrrgc.tsGenerator.TypeScriptGenerator
import option.TypescriptGeneratorOption

const val PREFIX = "declare namespace ServerSpec {"
const val SUFFIX = "}"

class TsModelGenerator(
    ktclazzScanner: KtClazzScanner,
    tsOptions: TypescriptGeneratorOption? = TypescriptGeneratorOption()
) {

    private val typescriptGenerator: TypeScriptGenerator = TypeScriptGenerator(
        rootClasses = ktclazzScanner.getKtClasses(),
        classTransformers = tsOptions!!.makeClassTransformers(),
        ignoreSuperclasses = tsOptions.makeIgnoreSuperClazzes(),
        mappings = tsOptions.makeMappings(),
    )

    fun generateDefintionText(): String {
        return "$PREFIX\n" +
                "${move4IndentInterfaces()}" +
                "$SUFFIX\n"
    }

    private fun move4IndentInterfaces() =
        typescriptGenerator.definitionsText
            .split("\n")
            .joinToString("\n") {
                TsMessageGenerator.makeMessage(it)
            }
}