package xyz.janek.simplates.language.psi

import com.intellij.psi.tree.IElementType
import xyz.janek.simplates.SimplatesLanguage

class SimplatesTokenType(debugName: String) : IElementType(debugName, SimplatesLanguage) {
    init {
        if (debugName == "CODE") {
            //fixme: if code fragment what to do
        }
    }
}
