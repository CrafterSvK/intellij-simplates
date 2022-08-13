package xyz.janek.simplates.language

import com.intellij.lang.Language
import com.intellij.lang.injection.general.Injection
import com.intellij.lang.injection.general.LanguageInjectionContributor
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import com.jetbrains.python.PythonLanguage
import org.intellij.plugins.intelliLang.inject.config.BaseInjection
import xyz.janek.simplates.language.psi.SimplatesTypes

class SimplatesInjectionContributor : LanguageInjectionContributor {
    override fun getInjection(context: PsiElement): Injection? {
        // If the current PSI context is a code block inside a template segment
        if (context.elementType == SimplatesTypes.CODE_BLOCK) {
            // Check if the block has been annotated with a context type
            if (context.parent?.elementType == SimplatesTypes.ANNOTATED_CODE_BLOCK) {
                val annotation = context.parent.children.firstOrNull {
                    it.elementType == SimplatesTypes.ANNOTATION
                } ?: throw IllegalStateException("Annotated code block element is missing an annotation children")
                val content = annotation.children.firstOrNull { it.elementType == SimplatesTypes.CONTENT_TYPE }

                // Find language matching the mime type provided by the annotation or fallback to python
                val language = content?.firstChild
                    ?.let { Language.findInstancesByMimeType(it.text).firstOrNull() }
                    ?: PythonLanguage.INSTANCE

                return BaseInjection("", language.id, "", "")
            }

            return BaseInjection("", PythonLanguage.INSTANCE.id, "", "")
        }

        return null
    }
}