// This is a generated file. Not intended for manual editing.
package xyz.janek.simplates.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static xyz.janek.simplates.language.psi.SimplatesTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class SimplatesParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return simplates_file(b, l + 1);
  }

  /* ********************************************************** */
  // annotation code_block
  public static boolean annotated_code_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotated_code_block")) return false;
    if (!nextTokenIs(b, SEPARATOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = annotation(b, l + 1);
    r = r && code_block(b, l + 1);
    exit_section_(b, m, ANNOTATED_CODE_BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // SEPARATOR (WHITE_SPACE content_type | [WHITE_SPACE] EOL)
  public static boolean annotation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation")) return false;
    if (!nextTokenIs(b, SEPARATOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEPARATOR);
    r = r && annotation_1(b, l + 1);
    exit_section_(b, m, ANNOTATION, r);
    return r;
  }

  // WHITE_SPACE content_type | [WHITE_SPACE] EOL
  private static boolean annotation_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = annotation_1_0(b, l + 1);
    if (!r) r = annotation_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // WHITE_SPACE content_type
  private static boolean annotation_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHITE_SPACE);
    r = r && content_type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [WHITE_SPACE] EOL
  private static boolean annotation_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = annotation_1_1_0(b, l + 1);
    r = r && consumeToken(b, EOL);
    exit_section_(b, m, null, r);
    return r;
  }

  // [WHITE_SPACE]
  private static boolean annotation_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_1_1_0")) return false;
    consumeToken(b, WHITE_SPACE);
    return true;
  }

  /* ********************************************************** */
  // (WHITE_SPACE | EOL | CODE) *
  public static boolean code_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "code_block")) return false;
    Marker m = enter_section_(b, l, _NONE_, CODE_BLOCK, "<code block>");
    while (true) {
      int c = current_position_(b);
      if (!code_block_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "code_block", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // WHITE_SPACE | EOL | CODE
  private static boolean code_block_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "code_block_0")) return false;
    boolean r;
    r = consumeToken(b, WHITE_SPACE);
    if (!r) r = consumeToken(b, EOL);
    if (!r) r = consumeToken(b, CODE);
    return r;
  }

  /* ********************************************************** */
  // CONTENT_TYPE_TOKEN [WHITE_SPACE VIA WHITE_SPACE FUNCTION_NAME]
  public static boolean content_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "content_type")) return false;
    if (!nextTokenIs(b, CONTENT_TYPE_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CONTENT_TYPE_TOKEN);
    r = r && content_type_1(b, l + 1);
    exit_section_(b, m, CONTENT_TYPE, r);
    return r;
  }

  // [WHITE_SPACE VIA WHITE_SPACE FUNCTION_NAME]
  private static boolean content_type_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "content_type_1")) return false;
    parseTokens(b, 0, WHITE_SPACE, VIA, WHITE_SPACE, FUNCTION_NAME);
    return true;
  }

  /* ********************************************************** */
  // template_segment *
  static boolean simplates_file(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simplates_file")) return false;
    while (true) {
      int c = current_position_(b);
      if (!template_segment(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "simplates_file", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // !<<eof>> (annotated_code_block | code_block)
  public static boolean template_segment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "template_segment")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TEMPLATE_SEGMENT, "<template segment>");
    r = template_segment_0(b, l + 1);
    r = r && template_segment_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // !<<eof>>
  private static boolean template_segment_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "template_segment_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !eof(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // annotated_code_block | code_block
  private static boolean template_segment_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "template_segment_1")) return false;
    boolean r;
    r = annotated_code_block(b, l + 1);
    if (!r) r = code_block(b, l + 1);
    return r;
  }

}
