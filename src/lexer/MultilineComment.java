package lexer;

import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 * High priority token, recognizes multi line comments.
 *
 * @author Benedikt Wotka
 */
@Prio(value = 1)
public class MultilineComment extends Token {

  private String content;
  Logger lexerLog;


  public MultilineComment() {
    super();
    lexerLog = Logger.getLogger("LexLoggingToken");
    pattern = Pattern.compile("^/\\*(.|[\\r\\n])*?\\*/");
  }

  /**
   * Copy Constructor, creates a new Token with the same values.
   *
   * @param oldMCom original Token
   */
  public MultilineComment(MultilineComment oldMCom) {
    this();
    content = oldMCom.getContent();
  }

  @Override
  protected Token getToken() {
    lexerLog.info("Token " + this.getClass().getName() + " was used.");
    Token newMCom = new MultilineComment(this);
    return newMCom;
  }

  @Override
  protected String getContent() {
    return content;
  }

  @Override
  protected void setContent(String pcontent) {
    content = pcontent;
  }
}
