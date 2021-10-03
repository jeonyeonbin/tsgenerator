package finder

import java.lang.reflect.Method

class MethodParameterFinder : MethodFinder {
    override fun getClazzName(method: Method): List<String> =
        method.genericParameterTypes.map {
            it.typeName
        }
}