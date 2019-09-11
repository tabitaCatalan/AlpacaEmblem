package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import model.items.nonMagic.Axe;
import org.junit.jupiter.api.Test;

/**
 * @author Ignacio Slater Muñoz
 */
public class FighterTest extends AbstractTestUnit {

  private Fighter testFighter;

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public void setTestUnit() {
    testFighter = new Fighter(50, 2, field.getCell(2, 2));
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public IUnit getTestUnit() {
    return testFighter;
  }


  /**
   * Checks if the axe is equipped correctly to the unit
   */
  @Test
  @Override
  public void equipAxeTest() {
    checkCorrectEquippedItem(testFighter, axe);
  }


  @Override
  public void equipTestUnit(){
    Axe testAxe = new Axe("Test Axe", 10, 1, 2);
    getTestUnit().addItem(testAxe);
    getTestUnit().equipItem(testAxe);
  }

  @Override
  public void attackEquippedUnitsTest(){
    normalDamageTest(archer);
    normalDamageTest(cleric);
    normalDamageTest(fighter);
    strongDamageTest(hero);
    weakDamageTest(swordMaster);
  }


}