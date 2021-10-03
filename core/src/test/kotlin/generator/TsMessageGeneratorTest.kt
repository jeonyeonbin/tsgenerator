package generator

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class TsMessageGeneratorTest {

    @ValueSource(strings = ["testInterface", "tsgenerator", "etc"])
    @ParameterizedTest
    fun `ts generator line message export interface test`(param: String) {
        val expected = TsMessageGenerator.makeMessage(
            "interface $param"
        )

        assertEquals(
            expected, "    export interface $param"
        )
    }

    @ValueSource(strings = ["testInterface", "tsgenerator", "etc"])
    @ParameterizedTest
    fun `ts generator line message export type test`(param: String) {
        val expected = TsMessageGenerator.makeMessage(
            "type $param"
        )

        assertEquals(
            expected, "    export type $param"
        )
    }

    @ValueSource(strings = ["a: string | null;", "b: string", "c: Test"])
    @ParameterizedTest
    fun `ts generator line message variable type test`(param: String) {
        val expected = TsMessageGenerator.makeMessage(param)

        assertEquals(
            expected, "    $param"
        )
    }

    @Test
    fun `ts generator empty string`() {
        val expected = TsMessageGenerator.makeMessage("")

        assertEquals(
            expected, ""
        )
    }

}