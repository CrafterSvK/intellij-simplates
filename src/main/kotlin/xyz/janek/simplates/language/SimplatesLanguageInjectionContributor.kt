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
            val parent = context.parent

            if (parent != null && parent.elementType == SimplatesTypes.ANNOTATED_CODE_BLOCK) {
                val contentType = parent.firstChild?.firstChild?.nextSibling?.nextSibling

                if (contentType != null && contentType.elementType == SimplatesTypes.CONTENT_TYPE) {
                    val languages = Language.findInstancesByMimeType(contentType.text).toTypedArray()

                    if (languages.isNotEmpty()) {
                        language = languages[0]
                    }
                }
            }
        }

        if (language != null) {
            return SimpleInjection(language, "", "", null)
        }

        return SimpleInjection(PythonLanguage.INSTANCE, "", "", null)
    }
}