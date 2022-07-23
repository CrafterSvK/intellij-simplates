package xyz.janek.simplates

import com.intellij.ide.actions.CreateFileFromTemplateAction
import com.intellij.ide.actions.CreateFileFromTemplateDialog
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory
import org.jetbrains.annotations.Nls

//todo: Create Simplates file
class CreateSimplatesFileAction :
    CreateFileFromTemplateAction("Simplates File", "Create simplates file", SimplatesIcons.file) {
    companion object {
        const val TEMPLATE_NAME: String = "Simplates File"

        @Nls
        private val name = "Action text"
    }

    override fun buildDialog(project: Project, directory: PsiDirectory, builder: CreateFileFromTemplateDialog.Builder) {
        builder.setTitle("Create Action Dialog Title")
    }

    override fun getActionName(directory: PsiDirectory?, newName: String, templateName: String?): String {
        return "Aaa"
    }
}
