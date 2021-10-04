package default

import generator.AbstractTypescriptGenerator
import generator.TsModelGenerator
import scanner.TypescriptOuterClazzScanner

class DefaultTypescriptGenerator(vararg packageNames: String) : AbstractTypescriptGenerator() {
    override val tsModelGenerator: TsModelGenerator =
        TsModelGenerator(ktclazzScanner = TypescriptOuterClazzScanner(packageNames.toList()))
}