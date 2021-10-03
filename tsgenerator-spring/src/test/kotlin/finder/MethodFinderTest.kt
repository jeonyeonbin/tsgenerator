package finder

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import sample.Sample
import sample.Sample2

class MethodFinderTest {

    fun sampleTest(sample: Sample): List<Sample2>
        = listOf(
            Sample2(data = "test")
        )

    @Test
    fun `find method return and param`() {
        // given
        val method = this.javaClass.getDeclaredMethod("sampleTest", Sample::class.java)

        // when
        val types = listOf(MethodReturnFinder(), MethodParameterFinder())
            .map {
                it.findGenericWrappedClazz(method)
            }
            .flatten()
            .sorted()

        // then
        Assertions.assertEquals(
            types,
            listOf("sample.Sample", "sample.Sample2")
        )
    }
}