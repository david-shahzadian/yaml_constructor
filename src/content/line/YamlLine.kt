package content.line

import content.YamlContentBuilder

internal abstract class YamlLine {

    companion object {
        fun header(name: String): YamlLine {
            return YamlHeader(name)
        }
    }

    fun content(): String {
        val builder = YamlContentBuilder()
        onContentBuild(builder)
        return builder.build()
    }

    protected abstract fun onContentBuild(builder: YamlContentBuilder)
}

internal class YamlHeader(private val name: String) : YamlLine() {

    override fun onContentBuild(builder: YamlContentBuilder) {
        builder.content(name)
        builder.colon()
        builder.indent()
    }
}