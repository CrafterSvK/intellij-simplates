package xyz.janek.simplates.language

import com.intellij.lang.Language
import com.intellij.lang.injection.MultiHostInjector
import com.intellij.lang.injection.MultiHostRegistrar
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiLanguageInjectionHost
import com.intellij.psi.util.elementType
import com.jetbrains.python.PythonLanguage
import xyz.janek.simplates.language.psi.SimplatesTypes
import xyz.janek.simplates.language.psi.impl.SimplatesCodeBlockImpl

class SimplatesInjector : MultiHostInjector {
    override fun getLanguagesToInject(registrar: MultiHostRegistrar, context: PsiElement) {
        // Check if the block has been annotated with a context type
        if (context.parent?.elementType == SimplatesTypes.ANNOTATED_CODE_BLOCK) {
            val language = this.getLanguageToInject(context)

            if (language !is PythonLanguage) {
                registrar
                    .startInjecting(language)
                    .addPlace(null, null, context as PsiLanguageInjectionHost, TextRange.allOf(context.text))
                    .doneInjecting()
            } else {
                registrar
                    .startInjecting(PythonLanguage.INSTANCE)

                val firstCodeBlock = context.containingFile.firstChild.children.find {
                    it.elementType == SimplatesTypes.CODE_BLOCK
                }

                if (firstCodeBlock != null) {
                    registrar.addPlace(
                        null,
                        "\n",
                        firstCodeBlock as PsiLanguageInjectionHost,
                        TextRange.allOf(firstCodeBlock.text)
                    )
                }

                registrar
                    .addPlace(null, null, context as PsiLanguageInjectionHost, TextRange.allOf(context.text))
                    .doneInjecting()
            }
        }
    }

    private fun getLanguageToInject(context: PsiElement): Language {
        val annotation = context.parent.children.firstOrNull {
            it.elementType == SimplatesTypes.ANNOTATION
        } ?: throw IllegalStateException("Annotated code block element is missing an annotation children")
        val content = annotation.children.firstOrNull {
            it.elementType == SimplatesTypes.CONTENT_TYPE
        }

        return content?.firstChild?.let { Language.findInstancesByMimeType(it.text).firstOrNull() }
            ?: PythonLanguage.INSTANCE
    }

    override fun elementsToInjectIn(): MutableList<out Class<out PsiElement>> {
        return listOf(SimplatesCodeBlockImpl::class.java).toMutableList()
    }
}