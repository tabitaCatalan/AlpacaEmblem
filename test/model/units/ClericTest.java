package model.units;

import model.items.IEquipableItem;
import model.items.Staff;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Ignacio Slater Muñoz
 */
public class ClericTest extends AbstractTestUnit {

  private Cleric testCleric;
  private Staff testStaff;

  @Override
  public void setTestUnit() {
    testCleric = new Cleric(50, 2, field.getCell(2, 2));
  }

  @Override
  public void setTestItem(){testStaff = new Staff("Test Staff", 10, 1, 2);}

  @Override
  public IUnit getTestUnit() {
    return testCleric;
  }

  @Override
  public IEquipableItem getTestItem() {
    return testStaff;
  }

  /**
   * {@inheritDoc}
   *
   * Checks if the staff is equipped correctly to the unit
   */
  @Test
  @Override
  public void equipStaffTest() {
    checkCorrectEquippedItem(testCleric, staff);
  }

  @Override
  public void equipTestUnit(){
    getTestUnit().addItem(testStaff);
    getTestUnit().equipItem(testStaff);
  }

  @Override
  public void attackEquippedUnitsTest(){}

  /**
   * testUnit uses it's item to heal targetUnit
   */
  public void healUnitsTest(){
    checkHPAfterUseItemOnUnitTest(50, alpaca);
    checkHPAfterUseItemOnUnitTest(50, archer);
    checkHPAfterUseItemOnUnitTest(50, cleric);
    checkHPAfterUseItemOnUnitTest(50, fighter);
    checkHPAfterUseItemOnUnitTest(50, hero);
    checkHPAfterUseItemOnUnitTest(50, swordMaster);
  }

  @Override
  @Test
  void useItemOnUnEquippedTargetUnitsTest() {
    healUnitsTest();
  }

  @Override
  @Test
  void equipTargetsAndUseItemOnEquippedTargetUnitsTest() {
    equipTargetUnits();
    healUnitsTest();
  }

  @Test
  @Override
  public void isInRangeTest(){
    super.isInRangeTest();
    assertTrue(getTestUnit().isInRange(lightSorcerer));
  }

}