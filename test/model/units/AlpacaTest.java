package model.units;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test set for the alpaca unit
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class AlpacaTest extends AbstractTestUnit {

  private Alpaca alpaca;

  @Override
  public void setTestUnit() {
    alpaca = new Alpaca(50, 2, field.getCell(0, 0));
  }

  @Override
  public Alpaca getTestUnit() {
    return alpaca;
  }

  @Override
  @Test
  public void addItemMoreThanMaxTest(){
    assertTrue(getTestUnit().hasSpaceInInventory());
    getTestUnit().addItem(getAxe());
    getTestUnit().addItem(getBow());
    getTestUnit().addItem(getSpear());
    getTestUnit().addItem(getSword());
    assertTrue(getTestUnit().hasSpaceInInventory());
    assertEquals(4, getTestUnit().getNumberOfItems());
  }
}