package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import model.items.Staff;
import org.junit.jupiter.api.Test;

/**
 * @author Ignacio Slater Muñoz
 */
public class ClericTest extends AbstractTestUnit {

  private Cleric testCleric;

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public void setTestUnit() {
    testCleric = new Cleric(50, 2, field.getCell(2, 2));
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public IUnit getTestUnit() {
    return testCleric;
  }

  /**
   * Checks if the staff is equipped correctly to the unit
   */
  @Test
  @Override
  public void equipStaffTest() {
    checkCorrectEquippedItem(testCleric, staff);
  }

  @Override
  public void equipTestUnit(){
    Staff testStaff = new Staff("Test Staff", 10, 1, 2);
    getTestUnit().addItem(testStaff);
    getTestUnit().equipItem(testStaff);
  }

  @Override
  public void attackEquippedUnitsTest(){}

  /**
   * testUnit uses it's item to heal targetUnit
   */
  public void healUnitsTest(){
    useItemOnUnitTest(50, alpaca);
    useItemOnUnitTest(50, archer);
    useItemOnUnitTest(50, cleric);
    useItemOnUnitTest(50, fighter);
    useItemOnUnitTest(50, hero);
    useItemOnUnitTest(50, swordMaster);
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

}