package finder

import java.lang.reflect.Method

class MethodReturnFinder: MethodFinder {
    override fun getClazzName(method: Method): List<String> =
        listOf(method.genericReturnType.typeName)
}