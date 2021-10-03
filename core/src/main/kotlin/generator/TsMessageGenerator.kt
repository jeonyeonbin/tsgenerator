package generator

const val SPACE_4 = "    "

object TsMessageGenerator {
    private val exportMapper = setOf(
        "interface",
        "type"
    )

    private fun makeExportMessage(line: String) =
        if (exportMapper.any { line.startsWith(it) }) {
            "export $line"
        } else {
            line
        }

    fun makeMessage(line: String) =
        if (line.isBlank()) {
            line
        } else {
            "${SPACE_4}${makeExportMessage(line)}"
        }
}