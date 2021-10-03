package transformer

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import sample.Sample
import sample.Sample2

class MethodTransformerTest {

    fun sampleTest(param: Sample): List<Sample> =
        listOf(
            Sample(
                data = "test"
            )
        )

    fun sample2Test(param: Sample2): Set<Sample2> =
        setOf(
            Sample2(
                data = "test"
            )
        )

    @Test
    fun `method transformer extract className string`() {
        val methods =
            listOf(
                this.javaClass.getDeclaredMethod("sampleTest", Sample::class.java),
                this.javaClass.getDeclaredMethod("sample2Test", Sample2::class.java)
            )

        assertEquals(
            MethodTransformer(methods).getClazzNames(),
            listOf("sample.Sample", "sample.Sample2")
        )
    }

}