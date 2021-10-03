package generator

import scanner.SpringControllerBeanScanner
import scanner.TsModelGenerator

class SpringTsGenerator(vararg packageNames: String) {
    private val tsModelGenerator: TsModelGenerator =
        TsModelGenerator(ktclazzScanner = SpringControllerBeanScanner(packageNames.toList()))

    fun makeTsString(): String =
        tsModelGenerator.generateDefintionText()
}