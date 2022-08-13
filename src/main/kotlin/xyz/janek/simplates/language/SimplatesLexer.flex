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

%state HEAD_STATE CODE_STATE CHECK_CODE

%%
<YYINITIAL> {
    {BEGIN}                              { yybegin(HEAD_STATE); return SimplatesTypes.SEPARATOR; }
    {WHITE_SPACE}|({WHITE_SPACE}|{EOL})+ { return WHITE_SPACE; }
    [^]                                  { yybegin(CODE_STATE); }
}

<CODE_STATE> {
    [^]                                  { yybegin(CODE_STATE); }
    [^]/{EOL}+{BEGIN}                    { yybegin(YYINITIAL); return SimplatesTypes.CODE; }
    <<EOF>>                              { yybegin(YYINITIAL); return SimplatesTypes.CODE; }
}

<HEAD_STATE> {
    {EOL}+                               { yybegin(CODE_STATE); return SimplatesTypes.EOL; }
    {WHITE_SPACE}                        { return SimplatesTypes.WHITE_SPACE; }
    {CONTENT_TYPE}                       { return SimplatesTypes.CONTENT_TYPE_TOKEN; }
    "via"                                { return SimplatesTypes.VIA; }
    {FUNCTION_NAME}                      { return SimplatesTypes.FUNCTION_NAME; }
}

[^]                                      { return BAD_CHARACTER; }
