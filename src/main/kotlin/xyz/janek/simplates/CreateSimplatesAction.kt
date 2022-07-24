package xyz.janek.simplates

import com.intellij.ide.actions.CreateFileAction

class CreateSimplatesAction : CreateFileAction("Simplates File", "Create simplates file", SimplatesIcons.file) {
    override fun getDefaultExtension(): String {
        return SimplatesFileType.INSTANCE.defaultExtension
    }
}
