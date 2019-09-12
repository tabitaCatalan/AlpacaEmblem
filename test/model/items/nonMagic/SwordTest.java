package model.items.nonMagic;

import model.items.IEquipableItem;
import model.map.Location;
import model.units.IUnit;
import model.units.SwordMaster;
import org.junit.jupiter.api.Test;

/**
 * Test set for swords
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class SwordTest extends AbstractWeaponTest {

  private Sword testSword;
  private Sword wrongSword;
  private SwordMaster testSwordMaster;

  /**
   * Sets which item is going to be tested
   */
  @Override
  public void setTestItem() {
    expectedName = "Common sword";
    expectedPower = 10;
    expectedMinRange = 1;
    expectedMaxRange = 2;
    testSword = new Sword(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
  }

  /**
   * Sets up an item with wrong ranges setted.
   */
  @Override
  public void setWrongRangeItem() {
    wrongSword = new Sword("Wrong sword", 0, -1, -2);
  }

  /**
   * Sets the unit that will be equipped with the test item
   */
  @Override
  public void setTestUnit() {
    testSwordMaster = new SwordMaster(unitHP, unitMovement, new Location(0, 0));
  }

  @Override
  public IEquipableItem getWrongTestItem() {
    return wrongSword;
  }

  /**
   * @return the item being tested
   */
  @Override
  public INonMagical getTestItem() {
    return testSword;
  }

  /**
   * @return a unit that can equip the item being tested
   */
  @Override
  public IUnit getTestUnit() {
    return testSwordMaster;
  }

  @Override
  public void equipTestUnit(){
    equipUnit(testSwordMaster, testSword);
  }

  @Override
  @Test
  public void beingEquippedBySwordMaster() {
    checkCorrectEquippedItem(getSwordMaster(),getTestItem());
  }

  @Override
  public void attackEquippedTargetUnitsTest(){
    super.attackEquippedTargetUnitsTest();
    strongDamageTest(fighter);
    weakDamageTest(hero);
    normalDamageTest(swordMaster);
  }
}
