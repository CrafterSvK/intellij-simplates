package xyz.janek.simplates

import com.intellij.lang.Language
import com.intellij.openapi.util.IconLoader

object SimplatesLanguage : Language("Simplates")

class SimplatesIcons {
    companion object {
        val file = IconLoader.getIcon("/icons/simplates.svg", SimplatesIcons::class.java)
    }
}
