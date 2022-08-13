package xyz.janek.simplates.language.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.LiteralTextEscaper
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.PsiLanguageInjectionHost


class SimplatesCodeBlockImpl(node: ASTNode) : ASTWrapperPsiElement(node),
    SimplatesCodeBlock, PsiLanguageInjectionHost {
    private fun accept(visitor: SimplatesVisitor) {
        visitor.visitCodeBlock(this)
    }

    override fun accept(visitor: PsiElementVisitor) {
        if (visitor is SimplatesVisitor) accept(visitor) else super.accept(visitor)
    }

    override fun isValidHost(): Boolean {
        return true
    }

    override fun updateText(text: String): PsiLanguageInjectionHost {
        return this
    }

    override fun createLiteralTextEscaper(): LiteralTextEscaper<out PsiLanguageInjectionHost?> {
        return LiteralTextEscaper.createSimple(this)
    }
}
