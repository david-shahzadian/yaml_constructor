package constructor.extensions

import constructor.content.base.YamlContentBuilder
import constructor.content.element.YamlElement

fun customYamlElement(onInit: YamlContentBuilder.() -> Unit) : YamlElement {
    return object : YamlElement() {
        override fun onContentBuild(builder: YamlContentBuilder) {
            builder.onInit()
        }
    }
}