package test.content.element

import content.element.*
import org.junit.Test

class YamlElementTest {

    @Test
    fun `yaml header test`() {
        val header = "my_header"
        assert(YamlHeader(header).asYaml() == "$header:")
    }

    @Test
    fun `yaml anchor test`() {
        val anchorName = "my_anchor"
        assert(YamlAnchor(anchorName).asYaml() == "&$anchorName")
    }

    @Test
    fun `yaml array anchor test`() {
        val anchorName = "my_anchor"
        val anchor = YamlAnchor(anchorName)
        assert(YamlArrayAnchor(anchor).asYaml() == "- &$anchorName")
    }

    @Test
    fun `yaml anchor link test`() {
        val anchorName = "my_anchor"
        val anchor = YamlAnchor(anchorName)
        assert(YamlAnchorLink(anchor).asYaml() == "*$anchorName")
    }

    @Test
    fun `yaml anchor override test`() {
        val anchorName = "my_anchor"
        val anchor = YamlAnchor(anchorName)
        assert(YamlAnchorOverride(anchor).asYaml() == "<<: *$anchorName")
    }

    @Test
    fun `yaml array item test`() {
        val itemName = "my_array_item"
        assert(YamlArrayItem(itemName).asYaml() == "- $itemName")
    }

    @Test
    fun `yaml tag test`() {
        val tagName = "my_tag"
        assert(YamlTag(tagName).asYaml() == "!!$tagName")
    }

    @Test
    fun `yaml pair test`() {
        val key = "my_key"
        val value = "my_value"
        assert(YamlPair(key, value).asYaml() == "$key: $value")
        assert(YamlPair(key, value, false).asYaml() == "$key $value")
    }


    @Test
    fun `yaml multi line test`() {
        val line0 = YamlComment("my_comment")
        val line1 = YamlArrayAnchor(YamlAnchor("my_anchor"))
        val line2 = YamlPair("my_key", "my_value")
        val multiLine = YamlMultiLine(listOf(line0.asYaml(), line1.asYaml(), line2.asYaml()))
        assert(multiLine.asYaml() == "# ${line0.comment}\n- &${line1.anchor.anchorName}\n" +
                "${line2.key}: ${line2.value}")
    }

    @Test
    fun `yaml comment test`() {
        val comment = "my_comment"
        assert(YamlComment(comment).asYaml() == "# $comment")
    }
}