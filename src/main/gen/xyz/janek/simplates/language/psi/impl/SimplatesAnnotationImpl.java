// This is a generated file. Not intended for manual editing.
package xyz.janek.simplates.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static xyz.janek.simplates.language.psi.SimplatesTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;

public class SimplatesAnnotationImpl extends ASTWrapperPsiElement implements SimplatesAnnotation {

  public SimplatesAnnotationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimplatesVisitor visitor) {
    visitor.visitAnnotation(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SimplatesVisitor) accept((SimplatesVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SimplatesContentType getContentType() {
    return findChildByClass(SimplatesContentType.class);
  }

  @Override
  @Nullable
  public PsiElement getEol() {
    return findChildByType(EOL);
  }

  @Override
  @NotNull
  public PsiElement getSeparator() {
    return findNotNullChildByType(SEPARATOR);
  }

  @Override
  @Nullable
  public PsiElement getWhiteSpace() {
    return findChildByType(WHITE_SPACE);
  }

}
