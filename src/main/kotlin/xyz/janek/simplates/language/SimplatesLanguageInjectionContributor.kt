package xyz.janek.simplates.language

import com.intellij.lang.Language
import com.intellij.lang.injection.general.Injection
import com.intellij.lang.injection.general.LanguageInjectionContributor
import com.intellij.lang.injection.general.SimpleInjection
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import com.jetbrains.python.PythonLanguage
import xyz.janek.simplates.language.psi.SimplatesTypes

class SimplatesLanguageInjectionContributor : LanguageInjectionContributor {
    override fun getInjection(context: PsiElement): Injection {
        var language: Language? = null
        if (context.elementType == SimplatesTypes.CODE_BLOCK) {
            val annotation = context.prevSibling?.prevSibling

            if (annotation != null && annotation.elementType == SimplatesTypes.ANNOTATION) {
                val contentType = annotation.firstChild?.nextSibling?.nextSibling?.text

                if (contentType != null) {
                    val languages = Language.findInstancesByMimeType(contentType).toTypedArray()

                    if (languages.isNotEmpty()) {
                        language = languages[0]
                    }
                }
            }
        }

        if (language != null) {
            return SimpleInjection(language, "", "", null)
        }

        return SimpleInjection(PythonLanguage.INSTANCE, "", "", "")
    }
}