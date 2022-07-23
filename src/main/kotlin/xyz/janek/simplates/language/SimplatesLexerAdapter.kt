package xyz.janek.simplates.language

import com.intellij.lexer.FlexAdapter

class SimplatesLexerAdapter : FlexAdapter(SimplatesLexer(null))