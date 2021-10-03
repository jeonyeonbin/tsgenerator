package finder

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import sample.Sample

class MethodParameterFinderTest {
    fun sampleTest(data: Sample) {

    }

    @Test
    fun findMethodParam() {
        val method = this.javaClass.getDeclaredMethod("sampleTest", Sample::class.java)

        assertEquals(
            MethodParameterFinder().findGenericWrappedClazz(method),
            listOf("sample.Sample")
        )
    }
}