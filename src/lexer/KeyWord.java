package lexer;

import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 * medium priority token, recognizes typical java keywords.
 *
 * @author Benedikt Wotka
 */
@Prio(value = 2)
public class KeyWord extends Token {

  private String content;
  Logger lexerLog;


  public KeyWord() {
    super();
    lexerLog = Logger.getLogger("LexLoggingToken");
    pattern = Pattern.compile("^(public|private|protected|abstract|void)");
  }

  /**
   * Copy Constructor, creates a new Token with the same values.
   *
   * @param oldKW original Token
   */
  public KeyWord(KeyWord oldKW) {
    this();
    content = oldKW.getContent();
  }

  @Override
  protected Token getToken() {
    lexerLog.info("Token " + this.getClass().getName() + " was used.");
    Token newKW = new KeyWord(this);
    return newKW;
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
