package xyz.janek.simplates.language

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import xyz.janek.simplates.language.psi.SimplatesTypes


class SimplatesSyntaxHighlighter : SyntaxHighlighterBase() {
    companion object {
        private val TAG = createTextAttributesKey("SIMPLATES_TAG", DefaultLanguageHighlighterColors.MARKUP_TAG)
        private val CONTENT_TYPE = createTextAttributesKey("SIMPLATES_KEY", DefaultLanguageHighlighterColors.STRING)
        private val VIA = createTextAttributesKey("SIMPLATES_VAL", DefaultLanguageHighlighterColors.KEYWORD)

        private val TAG_KEYS = arrayOf(TAG)
        private val CONTENT_TYPE_KEYS = arrayOf(CONTENT_TYPE)
        private val VIA_KEYS = arrayOf(VIA)

        private val EMPTY_KEYS = arrayOfNulls<TextAttributesKey>(0)
    }

    override fun getHighlightingLexer(): Lexer {
        return SimplatesLexerAdapter()
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<out TextAttributesKey?> {
        if (tokenType == SimplatesTypes.BEGIN) {
            return TAG_KEYS
        }
        if (tokenType == SimplatesTypes.CONTENT_TYPE) {
            return CONTENT_TYPE_KEYS
        }
        if (tokenType == SimplatesTypes.VIA_TOKEN) {
            return VIA_KEYS
        }

        return EMPTY_KEYS
    }
}
