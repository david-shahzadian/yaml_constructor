package extension

import content.YamlContentBuilder

fun yamlLine(init: YamlContentBuilder.() -> Unit): String {
    val builder = YamlContentBuilder()
    init(builder)
    return builder.build()
}