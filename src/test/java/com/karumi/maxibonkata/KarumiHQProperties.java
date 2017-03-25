package com.karumi.maxibonkata;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import java.util.List;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@RunWith(JUnitQuickcheck.class)
public class KarumiHQProperties {

  @Mock Chat chat;

  private KarumiHQs karumiHQs;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);

    karumiHQs = new KarumiHQs(chat);
  }

  @Property
  public void numberOfMaxibonsIsAlwaysOverTwo(
      @From(DevelopersGenerator.class) Developer developer) {
    karumiHQs.openFridge(developer);

    assertTrue(karumiHQs.getMaxibonsLeft() > 2);
  }

  @Property
  public void afterAGroupOfKarumiesOpenTheFridgeTheNumberOfMaxibonsIsOverTwo(
      List<@From(KarumiesGenerator.class) Developer> developers) {
    karumiHQs.openFridge(developers);

    assertTrue(karumiHQs.getMaxibonsLeft() > 2);
  }

  @Property
  public void ifHungryDeveloperOpenTheFridgeSendChatMessage(
      @From(HungryDevelopersGenerator.class) Developer developer) {

    karumiHQs.openFridge(developer);

    verify(chat).sendMessage(
        "Hi guys, I'm " + developer.getName() + ". We need more maxibons!");
  }

  @Property
  public void ifMultipleHungryDeveloperOpenTheFridgeSendChatMessages(
      List<@From(HungryDevelopersGenerator.class) Developer> developers) {

    assumeTrue(developers.size() > 0);

    karumiHQs.openFridge(developers);

    verify(chat, atLeastOnce()).sendMessage(anyString());
  }

  @Property
  public void ifNotSoHungryDeveloperOpenTheFridgeNeverSendChatMessage(
      @From(NotSoHungryDevelopersGenerator.class) Developer developer) {

    karumiHQs.openFridge(developer);

    verify(chat, never()).sendMessage(anyString());
  }
}
