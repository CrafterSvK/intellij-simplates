package xyz.janek.simplates

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class SimplatesFileType : LanguageFileType(SimplatesLanguage) {
    companion object {
        val INSTANCE = SimplatesFileType()
    }

    override fun getName(): String {
        return "Simplates"
    }

    override fun getDescription(): String {
        return "Simplates file"
    }

    override fun getDefaultExtension(): String {
        return "spt"
    }

    override fun getIcon(): Icon {
        return SimplatesIcons.file
    }
}