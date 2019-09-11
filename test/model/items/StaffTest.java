package model.items;

import model.map.Location;
import model.units.Cleric;
import model.units.IUnit;

/**
 * Test set for staffs
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class StaffTest extends AbstractHealerTest {

  private Staff staff;
  private Staff wrongStaff;
  private Cleric cleric;

  /**
   * Sets which item is going to be tested
   */
  @Override
  public void setTestItem() {
    super.setTestItem();
    expectedName = "Common staff";
    staff = new Staff(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
  }

  /**
   * Sets up an item with wrong ranges setted.
   */
  @Override
  public void setWrongRangeItem() {
    wrongStaff = new Staff("Wrong staff", 0, -1, -2);
  }

  /**
   * Sets the unit that will be equipped with the test item
   */
  @Override
  public void setTestUnit() {
    cleric = new Cleric(unitHP, unitMovement, new Location(0, 0));
  }

  @Override
  public IEquipableItem getWrongTestItem() {
    return wrongStaff;
  }

  /**
   * @return the item being tested
   */
  @Override
  public IHealer getTestItem() {
    return staff;
  }

  /**
   * @return a unit that can equip the item being tested
   */
  @Override
  public IUnit getTestUnit() {
    return cleric;
  }
}
