package xyz.janek.simplates.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static generated.GeneratedTypes.*;

%%

%{
  public _SimplatesLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class SimplatesLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

BEGIN=\[---+]
CONTENTTYPE=[a-z]+"/"[a-z.+\-]+
FUNCTIONNAME=[^ \t\n\x0B\f\r]+
SPACE=[ \t\n\x0B\f\r]+
CODE=.*

%%
<YYINITIAL> {
  {WHITE_SPACE}       { return WHITE_SPACE; }


  {BEGIN}             { return BEGIN; }
  {CONTENTTYPE}       { return CONTENTTYPE; }
  {FUNCTIONNAME}      { return FUNCTIONNAME; }
  {SPACE}             { return SPACE; }
  {CODE}              { return CODE; }

}
