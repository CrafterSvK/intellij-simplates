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

public class SimplatesContentTypeImpl extends ASTWrapperPsiElement implements SimplatesContentType {

  public SimplatesContentTypeImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimplatesVisitor visitor) {
    visitor.visitContentType(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SimplatesVisitor) accept((SimplatesVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getContentTypeToken() {
    return findNotNullChildByType(CONTENT_TYPE_TOKEN);
  }

  @Override
  @Nullable
  public PsiElement getFunctionName() {
    return findChildByType(FUNCTION_NAME);
  }

}
