package xyz.janek.simplates

import com.intellij.lang.Language
import com.intellij.openapi.util.IconLoader
import icons.PythonIcons

object SimplatesLanguage : Language("Simplates")

class SimplatesIcons {
    companion object {
        val file = IconLoader.getIcon("/icons/file.svg", SimplatesIcons::class.java)
    }
}
