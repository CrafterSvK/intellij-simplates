// This is a generated file. Not intended for manual editing.
package generated.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static xyz.janek.simplates.language.psi.SimplatesTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import xyz.janek.simplates.language.psi.impl.*;

public class SimplatesAnnotatedCodeBlockImpl extends ASTWrapperPsiElement implements SimplatesAnnotatedCodeBlock {

  public SimplatesAnnotatedCodeBlockImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimplatesVisitor visitor) {
    visitor.visitAnnotatedCodeBlock(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SimplatesVisitor) accept((SimplatesVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public SimplatesAnnotation getAnnotation() {
    return findNotNullChildByClass(SimplatesAnnotation.class);
  }

  @Override
  @NotNull
  public SimplatesCodeBlock getCodeBlock() {
    return findNotNullChildByClass(SimplatesCodeBlock.class);
  }

}
