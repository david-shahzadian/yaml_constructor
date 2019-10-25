package test.content.line

import content.line.*
import org.junit.Test

class YamlLineTest {

    @Test
    fun `yaml header line test`() {
        val header = "my_header"
        val yamlHeaderLine = YamlHeaderLine(header)
        assert(yamlHeaderLine.asYaml() == "$header:")
    }

    @Test
    fun `yaml anchor line test`() {
        val anchor = "my_anchor"
        val anchorLine = YamlArrayAnchorLine(anchor)
        assert(anchorLine.asYaml() == "- &$anchor")
    }

    @Test
    fun `yaml anchor link line test`() {
        val anchor = "my_anchor"
        val anchorLink = YamlAnchorLinkLine(anchor)
        assert(anchorLink.asYaml() == "*$anchor")
    }

    @Test
    fun `yaml anchor array link line test`() {
        val anchor = "my_anchor"
        val anchorArrayLink = YamlArrayAnchorLinkLine(anchor)
        assert(anchorArrayLink.asYaml() == "- *$anchor")
    }

    @Test
    fun `yaml anchor override line test`() {
        val anchor = "my_anchor"
        val overrideLine = YamlAnchorOverrideLine(anchor)
        assert(overrideLine.asYaml() == "<<: *$anchor")
    }
}