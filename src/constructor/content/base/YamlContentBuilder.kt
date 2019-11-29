package constructor.content.base

import constructor.constant.YamlSymbol.ANCHOR
import constructor.constant.YamlSymbol.ANCHOR_LINK
import constructor.constant.YamlSymbol.ANCHOR_OVERRIDE
import constructor.constant.YamlSymbol.ARRAY_PREFIX
import constructor.constant.YamlSymbol.COLON
import constructor.constant.YamlSymbol.COMMENT
import constructor.constant.YamlSymbol.INDENT
import constructor.constant.YamlSymbol.NEW_LINE
import constructor.constant.YamlSymbol.QUOTE
import constructor.constant.YamlSymbol.TAB
import constructor.constant.YamlSymbol.TAG

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