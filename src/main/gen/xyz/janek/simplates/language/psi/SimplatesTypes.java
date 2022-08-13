// This is a generated file. Not intended for manual editing.
package xyz.janek.simplates.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import generated.psi.impl.*;

public interface SimplatesTypes {

  IElementType ANNOTATED_CODE_BLOCK = new SimplatesElementType("ANNOTATED_CODE_BLOCK");
  IElementType ANNOTATION = new SimplatesElementType("ANNOTATION");
  IElementType CODE_BLOCK = new SimplatesElementType("CODE_BLOCK");
  IElementType CONTENT_TYPE = new SimplatesElementType("CONTENT_TYPE");
  IElementType TEMPLATE_SEGMENT = new SimplatesElementType("TEMPLATE_SEGMENT");

  IElementType CODE = new SimplatesTokenType("CODE");
  IElementType CONTENT_TYPE_TOKEN = new SimplatesTokenType("CONTENT_TYPE_TOKEN");
  IElementType EOL = new SimplatesTokenType("EOL");
  IElementType FUNCTION_NAME = new SimplatesTokenType("FUNCTION_NAME");
  IElementType SEPARATOR = new SimplatesTokenType("SEPARATOR");
  IElementType VIA = new SimplatesTokenType("via");
  IElementType WHITE_SPACE = new SimplatesTokenType("WHITE_SPACE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ANNOTATED_CODE_BLOCK) {
        return new SimplatesAnnotatedCodeBlockImpl(node);
      }
      else if (type == ANNOTATION) {
        return new SimplatesAnnotationImpl(node);
      }
      else if (type == CODE_BLOCK) {
        return new SimplatesCodeBlockImpl(node);
      }
      else if (type == CONTENT_TYPE) {
        return new SimplatesContentTypeImpl(node);
      }
      else if (type == TEMPLATE_SEGMENT) {
        return new SimplatesTemplateSegmentImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
