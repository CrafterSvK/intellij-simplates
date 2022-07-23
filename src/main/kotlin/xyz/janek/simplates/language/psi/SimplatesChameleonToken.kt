package xyz.janek.simplates.language.psi

import com.intellij.lang.ASTNode
import com.intellij.lang.Language
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.ILazyParseableElementType

class SimplatesChameleonToken : ILazyParseableElementType("Simplates Chameleon Token") {
    override fun parseContents(chameleon: ASTNode): ASTNode {
        return super.parseContents(chameleon)
    }
}