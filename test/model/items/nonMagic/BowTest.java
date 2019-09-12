package model.items.nonMagic;

import static org.junit.jupiter.api.Assertions.assertTrue;

import model.items.IEquipableItem;
import model.map.Location;
import model.units.Archer;
import model.units.IUnit;
import org.junit.jupiter.api.Test;

/**
 * Test set for bows
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class BowTest extends AbstractWeaponTest {

  private Bow testBow;
  private Bow wrongBow;
  private Archer testArcher;

  /**
   * Sets which item is going to be tested
   */
  @Override
  public void setTestItem() {
    expectedName = "Common bow";
    expectedPower = 10;
    expectedMinRange = 2;
    expectedMaxRange = 4;
    testBow = new Bow(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
  }

  /**
   * Sets up an item with wrong ranges setted.
   */
  @Override
  public void setWrongRangeItem() {
    wrongBow = new Bow("Wrong bow", 10, 1, 1);
  }

  /**
   * Sets the unit that will be equipped with the test item
   */
  @Override
  public void setTestUnit() {
    testArcher = new Archer(unitHP, unitMovement, new Location(0, 0));
  }

  /**
   * Checks that the minimum range for a bow is greater than 1
   */
  @Override
  @Test
  public void incorrectRangeTest() {
    assertTrue(getWrongTestItem().getMinRange() > 1);
    assertTrue(getWrongTestItem().getMaxRange() >= getWrongTestItem().getMinRange());
  }

  @Override
  public IEquipableItem getWrongTestItem() {
    return wrongBow;
  }

  /**
   * @return the item being tested
   */
  @Override
  public INonMagical getTestItem() {
    return testBow;
  }

  /**
   * @return a unit that can equip the item being tested
   */
  @Override
  public IUnit getTestUnit() {
    return testArcher;
  }

  @Override
  public void equipTestUnit(){
    equipUnit(testArcher, testBow);
  }

  @Override
  @Test
  public void beingEquippedByArcher() {
    checkCorrectEquippedItemTest(getArcher(),getTestItem());
  }

  @Override
  public void attackEquippedTargetUnitsTest(){
    super.attackEquippedTargetUnitsTest();
    normalDamageTest(fighter);
    normalDamageTest(hero);
    normalDamageTest(swordMaster);
  }
}
