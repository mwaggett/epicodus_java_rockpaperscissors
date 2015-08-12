import org.fluentlenium.adapter.FluentTest;
import static org.junit.Assert.*;
import org.junit.*;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class RockpaperscissorsTest  {


  @Test
  public void checkWinner_rockBeatsScissors_true() {
    Rockpaperscissors rps = new Rockpaperscissors();
    Boolean expValue = true;
    assertEquals(expValue, rps.checkWinner("rock","scissors"));
  }

  @Test
  public void checkWinner_rockDoesntBeatPaper_false() {
    Rockpaperscissors rps = new Rockpaperscissors();
    Boolean expValue = false;
    assertEquals(expValue, rps.checkWinner("rock","paper"));
  }

  @Test
  public void checkWinner_takesCapitalizedInput_true() {
    Rockpaperscissors rps = new Rockpaperscissors();
    Boolean expValue = true;
    assertEquals(expValue, rps.checkWinner("PapeR","Rock"));
  }

  @Test
  public void checkInput_capitalsOkay_true() {
    Rockpaperscissors rps = new Rockpaperscissors();
    String expValue = "rock";
    assertEquals(expValue, rps.checkInput("RoCk"));
  }

  @Test
  public void checkInput_otherWordsNotAllowed_true() {
    Rockpaperscissors rps = new Rockpaperscissors();
    String expValue = "no";
    assertEquals(expValue, rps.checkInput("90 cAtS !! :)"));
  }

  @Test
  public void checkWinnerVsComputer_ComputerRandom() {
    Rockpaperscissors rps = new Rockpaperscissors();
    Boolean expValue = true;
    assertEquals(expValue, rps.checkWinnerVsComputer("rock"));
  }

  // public WebDriver webDriver = new HtmlUnitDriver();
  // public WebDriver getDefaultDriver() {
  //     return webDriver;
  // }
  //
  // @ClassRule
  // public static ServerRule server = new ServerRule();
  //
  // @Test
  // public void rootTest() {
  //     goTo("http://localhost:4567/");
  //     assertThat(pageSource()).contains("Leap year detector");
  // }
}
