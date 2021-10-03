package finder

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import sample.Sample

class MethodReturnFinderTest {
    fun sampleTest(): Sample =
        Sample(
            data = "test",
        )

    @Test
    fun findMethodReturnType() {
        val method = this.javaClass.getDeclaredMethod("sampleTest")

        assertEquals(
            MethodReturnFinder().findGenericWrappedClazz(method),
            listOf("sample.Sample")
        )
    }
}