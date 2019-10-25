package extensions

import content.base.YamlContentBuilder
import content.element.YamlElement

fun customYamlElement(onInit: YamlContentBuilder.() -> Unit) : YamlElement {
    return object : YamlElement() {
        override fun onContentBuild(builder: YamlContentBuilder) {
            builder.onInit()
        }
    }
}