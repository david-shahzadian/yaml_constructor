package content.line

import content.base.YamlContentBuilder
import content.line.base.YamlLine

/**
 * [asYaml] will return [header]:
 */
class YamlHeaderLine(private val header: String) : YamlLine() {

    override fun onContentBuild(builder: YamlContentBuilder) {
        builder.content(header)
        builder.colonSymbol()
    }
}

/**
 * [asYaml] will return - &[anchor]:
 */
class YamlArrayAnchorLine(private val anchor: String) : YamlLine() {

    override fun onContentBuild(builder: YamlContentBuilder) {
        builder.arrayPrefixSymbol()
        builder.indentSymbol()
        builder.anchorSymbol()
        builder.content(anchor)
    }
}

/**
 * [asYaml] will return *[anchor]:
 */
class YamlAnchorLinkLine(private val anchor: String) : YamlLine() {

    override fun onContentBuild(builder: YamlContentBuilder) {
        builder.anchorLinkSymbol()
        builder.content(anchor)
    }
}

/**
 * [asYaml] will return - *[anchor]:
 */
class YamlArrayAnchorLinkLine(private val anchor: String) : YamlLine() {

    override fun onContentBuild(builder: YamlContentBuilder) {
        builder.arrayPrefixSymbol()
        builder.indentSymbol()
        builder.anchorLinkSymbol()
        builder.content(anchor)
    }
}

/**
 * [asYaml] will return <<: *[anchor]:
 */
class YamlAnchorOverrideLine(private val anchor: String) : YamlLine() {

    override fun onContentBuild(builder: YamlContentBuilder) {
        builder.anchorOverrideSymbol()
        builder.colonSymbol()
        builder.indentSymbol()
        builder.anchorLinkSymbol()
        builder.content(anchor)
    }
}