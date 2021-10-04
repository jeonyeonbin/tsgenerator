package generator

import scanner.SpringControllerBeanScanner

class SpringTsGenerator(vararg packageNames: String): AbstractTypescriptGenerator() {
    override val tsModelGenerator: TsModelGenerator =
        TsModelGenerator(ktclazzScanner = SpringControllerBeanScanner(packageNames.toList()))
}