package com.karumi.maxibonkata;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitQuickcheck.class)
public class DeveloperProperties {

  @Property
  public void theNumberOfMaxibonsAssignedIsPositiveOrZero(
      @From(DevelopersGenerator.class) Developer developer) {

    assertTrue(developer.getNumberOfMaxibonsToGrab() >= 0);
  }

  @Test
  public void karuimesConsumeTheRightNumberOfMaxibons() {
    assertEquals(Karumies.ALBERTO.getNumberOfMaxibonsToGrab(), 1);
    assertEquals(Karumies.DAVIDE.getNumberOfMaxibonsToGrab(), 0);
    assertEquals(Karumies.JORGE.getNumberOfMaxibonsToGrab(), 1);
    assertEquals(Karumies.PEDRO.getNumberOfMaxibonsToGrab(), 3);
    assertEquals(Karumies.SERGIO.getNumberOfMaxibonsToGrab(), 2);
  }
}
