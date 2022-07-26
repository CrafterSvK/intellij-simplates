package xyz.janek.simplates.language

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import xyz.janek.simplates.SimplatesLanguage
import xyz.janek.simplates.language.parser.SimplatesParser
import xyz.janek.simplates.language.psi.SimplatesFile
import xyz.janek.simplates.language.psi.SimplatesTypes

class SimplatesParserDefinition : ParserDefinition {
    companion object {
        val WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE)
        val STRING_LITERALS = TokenSet.create(SimplatesTypes.CONTENT_TYPE)
        val FILE = IFileElementType(SimplatesLanguage)
    }

    override fun getWhitespaceTokens(): TokenSet {
        return WHITE_SPACES
    }

    override fun createLexer(project: Project?): Lexer {
        return SimplatesLexerAdapter()
    }

    override fun createParser(project: Project?): PsiParser {
        return SimplatesParser()
    }

    override fun getFileNodeType(): IFileElementType {
        return FILE
    }

    override fun getCommentTokens(): TokenSet {
        return TokenSet.EMPTY
    }

    override fun getStringLiteralElements(): TokenSet {
        return STRING_LITERALS
    }

    override fun createElement(node: ASTNode): PsiElement {
        return SimplatesTypes.Factory.createElement(node)
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return SimplatesFile(viewProvider)
    }
}
