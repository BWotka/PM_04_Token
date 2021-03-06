package lexer;

import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 * medium priority token, recognizes string content.
 *
 * @author Benedikt Wotka
 */
@Prio(value = 2)
public class StringContent extends Token {

  private String content;
  Logger lexerLog;


  public StringContent() {
    super();
    lexerLog = Logger.getLogger("LexLoggingToken");
    pattern = Pattern.compile("^(([\"|\']).*\\2)");
  }

  /**
   * Copy Constructor, creates a new Token with the same values.
   *
   * @param oldSC original Token
   */
  public StringContent(StringContent oldSC) {
    this();
    content = oldSC.getContent();
  }

  @Override
  protected Token getToken() {
    lexerLog.info("Token " + this.getClass().getName() + " was used.");
    Token newSC = new StringContent(this);
    return newSC;
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
