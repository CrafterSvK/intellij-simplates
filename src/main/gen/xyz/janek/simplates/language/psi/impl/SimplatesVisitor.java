// This is a generated file. Not intended for manual editing.
package xyz.janek.simplates.language.psi.impl;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class SimplatesVisitor extends PsiElementVisitor {

  public void visitAnnotatedCodeBlock(@NotNull SimplatesAnnotatedCodeBlock o) {
    visitPsiElement(o);
  }

  public void visitAnnotation(@NotNull SimplatesAnnotation o) {
    visitPsiElement(o);
  }

  public void visitCodeBlock(@NotNull SimplatesCodeBlock o) {
    visitPsiElement(o);
  }

  public void visitContentType(@NotNull SimplatesContentType o) {
    visitPsiElement(o);
  }

  public void visitTemplateSegment(@NotNull SimplatesTemplateSegment o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
