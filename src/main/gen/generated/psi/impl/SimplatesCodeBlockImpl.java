// This is a generated file. Not intended for manual editing.
package generated.psi.impl;

import java.util.List;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.LiteralTextEscaper;
import com.intellij.psi.PsiLanguageInjectionHost;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static xyz.janek.simplates.language.psi.SimplatesTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import xyz.janek.simplates.language.psi.impl.*;

public class SimplatesCodeBlockImpl extends ASTWrapperPsiElement implements SimplatesCodeBlock, PsiLanguageInjectionHost {

  public SimplatesCodeBlockImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimplatesVisitor visitor) {
    visitor.visitCodeBlock(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SimplatesVisitor) accept((SimplatesVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  public boolean isValidHost() {
    return true;
  }

  @Override
  public PsiLanguageInjectionHost updateText(@NotNull String text) {
    return this;
  }

  @Override
  public @NotNull LiteralTextEscaper<? extends PsiLanguageInjectionHost> createLiteralTextEscaper() {
    return LiteralTextEscaper.createSimple(this);
  }
}
