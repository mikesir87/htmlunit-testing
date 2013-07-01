package demo.ft;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gargoylesoftware.htmlunit.AlertHandler;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlUnorderedList;

public class MultipleAjaxRequestFT {

  private static final Logger logger = LoggerFactory.getLogger(MultipleAjaxRequestFT.class);
  private static final String BASE_PATH = "http://localhost:8080/htmlunit-connections/";
  private WebClient client = new WebClient(BrowserVersion.FIREFOX_17);
  
  @Before
  public void setUp() {
    client.setCssErrorHandler(new NoOpErrorHandler());
    client.setAlertHandler(new AlertHandler() {
      public void handleAlert(Page page, String message) {
        logger.error("javascript alert: " + message 
            + " on page " + page);
      }
    });
  }
  
  @Test
  public void testBackToBackRequests() throws Exception {
    final HtmlPage page = getHtmlPage("index.jsp");
    HtmlButton triggerButton =
        ((HtmlButton) page.getElementById("fireAjaxRequest"));
    ((HtmlInput) page.getElementById("wait")).setValueAttribute("4");
    triggerButton.click();
    triggerButton.click();
    
    (new Thread(new Runnable() {
      public void run() {
        logger.warn("Running");
        try {
          Thread.sleep(5000);
        }
        catch (Exception e) {
          logger.warn("OUCH");
        }
        logger.warn("Children: " + getAjaxLog(page).getChildElementCount());
      }
    })).start();
    client.waitForBackgroundJavaScript(10000);
    logger.warn("[Not in thread] Children: "
        + getAjaxLog(page).getChildElementCount());
  }
  
  protected HtmlPage getHtmlPage(String url) throws Exception {
    HtmlPage page = client.getPage(BASE_PATH + url);
    client.waitForBackgroundJavaScript(1000);
    return page;
  }
  
  private HtmlUnorderedList getAjaxLog(HtmlPage page) {
    return ((HtmlUnorderedList) page.getElementById("ajaxLog") );
  }
}
