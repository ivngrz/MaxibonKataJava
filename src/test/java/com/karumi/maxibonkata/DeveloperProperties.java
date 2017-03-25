package com.karumi.maxibonkata;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

@RunWith(JUnitQuickcheck.class)
public class DeveloperProperties {

  @Property()
  public void theNumberOfMaxibonsAssignedIsPositiveOrZero(
      @From(DevelopersGenerator.class) Developer developer) {

    System.out.println(developer);

    assertTrue(developer.getNumberOfMaxibonsToGrab() >= 0);
  }

}
