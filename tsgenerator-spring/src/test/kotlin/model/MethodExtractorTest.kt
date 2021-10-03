package model

import finder.MethodParameterFinder
import finder.MethodReturnFinder
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import sample.Sample

class MethodExtractorTest {

    fun sampleParamTest(data: Sample) {

    }

    fun sampleReturnTest() =
        Sample(
            data = "test"
        )

    @Test
    fun `Methods findClazzNames parameter`() {
        val method = this.javaClass.getDeclaredMethod("sampleParamTest", Sample::class.java)

        assertEquals(
            MethodExtractor(listOf(method)).findClazzNames(MethodParameterFinder()),
            listOf("sample.Sample")
        )
    }

    @Test
    fun `Methods findClazzNames return type`() {
        val method = this.javaClass.getDeclaredMethod("sampleReturnTest")

        assertEquals(
            MethodExtractor(listOf(method)).findClazzNames(MethodReturnFinder()),
            listOf("sample.Sample")
        )
    }
}