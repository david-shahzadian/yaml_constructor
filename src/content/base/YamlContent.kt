package content.base

/**
 * Base interface for all yaml format contents
 */
interface YamlContent {

    /**
     * @return yaml format string content
     */
    fun asYaml(): String
}