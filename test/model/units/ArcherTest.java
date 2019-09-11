package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import model.items.nonMagic.Bow;
import org.junit.jupiter.api.Test;

/**
 * Test set for the Archer unit.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class ArcherTest extends AbstractTestUnit {

  private Archer testArcher;

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public void setTestUnit() {
    testArcher = new Archer(50, 2, field.getCell(2, 2));
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public IUnit getTestUnit() {
    return testArcher;
  }

  /**
   * Checks if the bow is equipped correctly to the unit
   */
  @Test
  @Override
  public void equipBowTest() {
    checkCorrectEquippedItem(testArcher, bow);
  }

  @Override
  public void equipTestUnit(){
    Bow testBow = new Bow("Test Bow", 10, 1, 2);
    getTestUnit().addItem(testBow);
    getTestUnit().equipItem(testBow);
  }

  @Override
  public void attackEquippedUnitsTest(){
    normalDamageTest(archer);
    normalDamageTest(cleric);
    normalDamageTest(fighter);
    normalDamageTest(hero);
    normalDamageTest(swordMaster);
  }
}