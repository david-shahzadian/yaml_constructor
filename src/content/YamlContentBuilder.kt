package content

import constant.YamlSymbol.ANCHOR
import constant.YamlSymbol.ANCHOR_LINK
import constant.YamlSymbol.ANCHOR_OVERRIDE
import constant.YamlSymbol.ARRAY_PREFIX
import constant.YamlSymbol.COLON
import constant.YamlSymbol.COMMENT
import constant.YamlSymbol.INDENT
import constant.YamlSymbol.NEW_LINE
import constant.YamlSymbol.QUOTE
import constant.YamlSymbol.TAB
import constant.YamlSymbol.TAG

class YamlContentBuilder {

    private var finalContent: String = ""

    fun content(content: String) =
        apply { content.appendToContent() }

    fun indent() =
        apply { INDENT.appendToContent() }

    fun anchor() =
        apply { ANCHOR.appendToContent() }

    fun anchorLink() =
        apply { ANCHOR_LINK.appendToContent() }

    fun anchorOverride() =
        apply { ANCHOR_OVERRIDE.appendToContent() }

    fun tag() =
        apply { TAG.appendToContent() }

    fun quote() =
        apply { QUOTE.appendToContent() }

    fun comment() =
        apply { COMMENT.appendToContent() }

    fun tab() =
        apply { TAB.appendToContent() }

    fun arrayPrefix() =
        apply { ARRAY_PREFIX.appendToContent() }

    fun colon() =
        apply { COLON.appendToContent() }

    fun newLine() =
        apply { NEW_LINE.appendToContent() }

    fun build(): String = finalContent

    private fun String.appendToContent() {
        finalContent += this
    }
}