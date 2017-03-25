package com.karumi.maxibonkata;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.Before;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

@RunWith(JUnitQuickcheck.class)
public class KarumiHQProperties {

  private KarumiHQs karumiHQs;

  @Before
  public void setUp() throws Exception {
    karumiHQs = new KarumiHQs();
  }

  @Property
  public void numberOfMaxibonsIsAlwaysOverTwo(
      @From(DevelopersGenerator.class) Developer developer) {
    karumiHQs.openFridge(developer);

    assertTrue(karumiHQs.getMaxibonsLeft() > 2);
  }
}
