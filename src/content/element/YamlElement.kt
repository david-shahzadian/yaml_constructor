package content.element

import content.base.YamlContent
import content.base.YamlContentBuilder

/**
 * Base class for all yaml elements
 */
abstract class YamlElement : YamlContent {

    override fun asYaml(): String {
        val contentBuilder = YamlContentBuilder()
        onContentBuild(contentBuilder)
        return contentBuilder.build()
    }

    /**
     * Called when content build is required.
     * When realizing this function all the content should be added via [builder]
     */
    protected abstract fun onContentBuild(builder: YamlContentBuilder)
}

/**
 * Yaml element of type &[anchorName]
 */
class YamlAnchor(val anchorName: String) : YamlElement() {
    override fun onContentBuild(builder: YamlContentBuilder) {
        builder.anchorSymbol()
        builder.content(anchorName)
    }
}

/**
 * Yaml element of type *${anchor.name}
 */
class YamlAnchorLink(val anchor: YamlAnchor) : YamlElement() {
    override fun onContentBuild(builder: YamlContentBuilder) {
        builder.anchorLinkSymbol()
        builder.content(anchor.anchorName)
    }
}

/**
 * Yaml element of type <<: *${anchor.name}
 */
class YamlAnchorOverride(val anchor: YamlAnchor) : YamlElement() {
    override fun onContentBuild(builder: YamlContentBuilder) {
        builder.anchorOverrideSymbol()
        builder.colonSymbol()
        builder.indentSymbol()
        builder.content(YamlAnchorLink(anchor).asYaml())
    }
}

/**
 * Yaml element of type - [itemName]
 */
class YamlArrayItem(val itemName: String) : YamlElement() {
    override fun onContentBuild(builder: YamlContentBuilder) {
        builder.arrayPrefixSymbol()
        builder.indentSymbol()
        builder.content(itemName)
    }
}

/**
 * Yaml element of type !![tagName]
 */
class YamlTag(val tagName: String) : YamlElement() {
    override fun onContentBuild(builder: YamlContentBuilder) {
        builder.tagSymbol()
        builder.content(tagName)
    }
}