package xyz.janek.simplates.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import xyz.janek.simplates.language.psi.SimplatesTypes;

import static com.intellij.psi.TokenType.*;

%%

%{
  public SimplatesLexer() {
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
CONTENT_TYPE=[a-z]+"/"[a-z.+\-]+
FUNCTION_NAME=[a-zA-Z_][a-z0-9_]+
WHITE_SPACE=[ \t\n\x0B\f\r]+

%state HEAD_STATE
%state CODE_STATE

%%
<YYINITIAL> {
  {BEGIN}                              { yybegin(HEAD_STATE); return SimplatesTypes.BEGIN; }
  {WHITE_SPACE}|({WHITE_SPACE}|{EOL})+ { return WHITE_SPACE; }
//  [^]                                  { yybegin(CODE_STATE); }
}

<CODE_STATE> {
//  {EOL}+{BEGIN}                        { yybegin(YYINITIAL); return SimplatesTypes.CODE; }
//  {EOL}                                { yybegin(YYINITIAL);  return WHITE_SPACE; }
  [^]                                 { yybegin(CODE_STATE); }
  [^]/{EOL}+{BEGIN}                   { yybegin(YYINITIAL); return SimplatesTypes.CODE; }
}

<HEAD_STATE> {
  {EOL}                                { yybegin(CODE_STATE); return WHITE_SPACE; }
  {WHITE_SPACE}+                       { return SimplatesTypes.SEP_SPACE; }
  {CONTENT_TYPE}                       { return SimplatesTypes.CONTENT_TYPE; }
  "via"                                { return SimplatesTypes.VIA_TOKEN; }
  {FUNCTION_NAME}                      { return SimplatesTypes.FUNCTION_NAME; }
}

[^]                                    { return BAD_CHARACTER; }
