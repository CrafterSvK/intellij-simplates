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

public class SimplatesTemplateSegmentImpl extends ASTWrapperPsiElement implements SimplatesTemplateSegment {

  public SimplatesTemplateSegmentImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimplatesVisitor visitor) {
    visitor.visitTemplateSegment(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SimplatesVisitor) accept((SimplatesVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SimplatesAnnotatedCodeBlock getAnnotatedCodeBlock() {
    return findChildByClass(SimplatesAnnotatedCodeBlock.class);
  }

  @Override
  @Nullable
  public SimplatesCodeBlock getCodeBlock() {
    return findChildByClass(SimplatesCodeBlock.class);
  }

}
