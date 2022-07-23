package xyz.janek.simplates.language.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import xyz.janek.simplates.SimplatesFileType
import xyz.janek.simplates.SimplatesLanguage

class SimplatesFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, SimplatesLanguage) {
    override fun getFileType(): FileType {
        return SimplatesFileType.INSTANCE
    }

    override fun toString(): String {
        return "Simplates File"
    }
}