package model.units;

import model.items.IEquipableItem;
import model.items.nonMagic.Bow;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test set for the Archer unit.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class ArcherTest extends AbstractTestUnit {

  private Archer testArcher;
  private Bow testBow;

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public void setTestUnit() {
    testArcher = new Archer(50, 2, field.getCell(2, 2));
  }

  @Override
  public IUnit getTestUnit() {
    return testArcher;
  }

  @Override
  public void setTestItem(){testBow = new Bow("Test Bow", 10, 2, 3);}

  @Override
  public IEquipableItem getTestItem() {
    return testBow;
  }

  /**
   * Checks if the bow is equipped correctly to the unit
   */
  @Test
  @Override
  public void equipBowTest() {
    checkCorrectEquippedItem(testArcher, getBow());
  }

  @Override
  public void equipTestUnit(){
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

  /**
   * {@inheritDoc}
   *
   * Archer can't have adjacent units in range
   * */
  @Test
  @Override
  public void isInRangeTest(){
    super.isInRangeTest();
    assertFalse(getTestUnit().isInRange(lightSorcerer));
  }

}