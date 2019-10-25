package content.line.base

import content.base.YamlContent
import content.base.YamlContentBuilder

/**
 * Base class for all yaml line classes
 */
abstract class YamlLine : YamlContent {

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