package content.base

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

    fun indentSymbol() =
        apply { INDENT.appendToContent() }

    fun anchorSymbol() =
        apply { ANCHOR.appendToContent() }

    fun anchorLinkSymbol() =
        apply { ANCHOR_LINK.appendToContent() }

    fun anchorOverrideSymbol() =
        apply { ANCHOR_OVERRIDE.appendToContent() }

    fun tagSymbol() =
        apply { TAG.appendToContent() }

    fun quoteSymbol() =
        apply { QUOTE.appendToContent() }

    fun commentSymbol() =
        apply { COMMENT.appendToContent() }

    fun tabSymbol() =
        apply { TAB.appendToContent() }

    fun arrayPrefixSymbol() =
        apply { ARRAY_PREFIX.appendToContent() }

    fun colonSymbol() =
        apply { COLON.appendToContent() }

    fun newLineSymbol() =
        apply { NEW_LINE.appendToContent() }

    fun build(): String = finalContent

    private fun String.appendToContent() {
        finalContent += this
    }
}