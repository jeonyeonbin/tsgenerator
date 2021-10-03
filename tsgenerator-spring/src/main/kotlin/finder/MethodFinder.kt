package finder

import java.lang.reflect.Method
import java.util.regex.Pattern

private const val GENERIC_REGEX = "^(?:.+<)+([^>]+)>+$"
interface MethodFinder {

    fun getClazzName(method: Method): List<String>

    fun findGenericWrappedClazz(method: Method): List<String> =
        getClazzName(method)
            .mapNotNull {
                val pattern = Pattern.compile(GENERIC_REGEX)
                val match = pattern.matcher(it)
                if (match.find()) {
                    match.group(1)
                } else {
                    it
                }
            }
}